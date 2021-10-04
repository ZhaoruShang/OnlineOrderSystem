import { Button, Form, Input, message } from "antd";
import { useState } from "react";
import { LockOutlined, UserOutlined } from "@ant-design/icons";
import { businessLogin } from "../utils";

const BusinessLogin = ({onSuccess, registerForm}) => {
    const [loading, setLoading] = useState(false);

    const onFinish = (data) => {
        setLoading(true);
        businessLogin(data).then(() => {
            message.success(`Login Successful`);
            onSuccess();
          }).catch((err) => {
            message.error(err.message);
          }).finally(() => { setLoading(false) });
      };

        return (
          <Form
            name="business_login"
            onFinish={onFinish}
            style={{
              width: 300,
              margin: "auto",
            }}
          >
            <Form.Item
              name="username"
              rules={[{ required: true, message: "Please input your Username!" }]}
            >
              <Input prefix={<UserOutlined />} placeholder="Username" />
            </Form.Item>
            <Form.Item
              name="password"
              rules={[{ required: true, message: "Please input your Password!" }]}
            >
              <Input.Password prefix={<LockOutlined />} placeholder="Password" />
            </Form.Item>
     
            <Form.Item>
              <div style = {{display: "flex", 
            justifyContent: "space-between"}}>
                <Button type="primary" htmlType="Register" onClick={registerForm}>
                New User? Register
                </Button>
                <Button type="primary" htmlType="submit" loading={loading}>
                Login
                </Button>  
              </div>                  
            </Form.Item>
          </Form>
        );
}

export default BusinessLogin
