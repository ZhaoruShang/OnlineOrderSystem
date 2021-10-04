import {useState, useEffect} from 'react'
import { Table, Input, InputNumber, Popconfirm, Form, Typography } from 'antd';

const MyRestaurantTable = () => {
    [dataSource, setDataSource] = useState();
    

    const columns =[
        {
            title: 'Id',
            dataIndex: 'id',
        },
        {
            title: 'Restaurant Name',
            dataIndex: 'restaurantName',
            editable: true,
        },
        {
            title: 'Address',
            dataIndex: 'address',
            editable: true,
        },
        {
            title: 'Phone Number',
            dataIndex: 'phoneNumber',
            editable: true,
        },
        {
            title: 'Logo',
            dataIndex: 'logo',
            editable: true,
        },

        {
            title: 'Update',
            dataIndex: 'update',
            render: (_, record) =>
              dataSource.length >= 1 ? (
                <Popconfirm title="Sure to update?" onConfirm={() => handleUpdate(record)}>
                  <a>Update</a>
                </Popconfirm>
              ) : null,
          },
          {
            title: 'Delete',
            dataIndex: 'delete',
            render: (_, record) =>
              dataSource.length >= 1 ? (
                <Popconfirm title="Sure to delete?" onConfirm={() => handleDelete(record.id)}>
                  <a>Delete</a>
                </Popconfirm>
              ) : null,
          },
    ];

    return (
        <div>
            <Button
                onClick={handleAdd}
                type="primary"
                style={{
                    marginBottom: 16,
                }}
                >
                Add a restaurant
                </Button>
                <Table
                components={components}
                rowClassName={() => 'editable-row'}
                bordered
                dataSource={dataSource}
                columns={columns}
                />
        </div>
    )
}

export default MyRestaurantTable
