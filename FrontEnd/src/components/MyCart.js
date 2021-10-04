import { Button, Drawer, List, message, Typography, Tooltip} from "antd";
import { useEffect, useState } from "react";
import { checkout, getCart, removeItemFromCart } from "../utils";
import {MinusSquareFilled} from "@ant-design/icons"
 
const { Text } = Typography;

const RemoveItemButton = ({ itemId, updateCart }) => {
  const [loading, setLoading] = useState(false);
 
  const removeFromCart = () => {
    setLoading(true);
    removeItemFromCart(itemId)
      .then(() => {
        message.success(`Successfully remove item`);
        updateCart()
      })
      .catch((err) => message.error(err.message))
      .finally(() => {
        setLoading(false);
      });
      
  };
 
  return (
    <Tooltip title="Remove from shopping cart">
      <Button
        style ={{backgroundColor: "#f44336",
      outlineColor: "#f44336"}}
        loading={loading}
        type="primary"
        icon={<MinusSquareFilled />}
        onClick={removeFromCart}
      />
    </Tooltip>
  );
};

const MyCart = () => {
  const [cartVisible, setCartVisible] = useState(false);
  const [cartData, setCartData] = useState();
  const [loading, setLoading] = useState(false);
  const [checking, setChecking] = useState(false);
 
  useEffect(() => {
    if (!cartVisible) {
      return;
    }
 
    setLoading(true);
    getCart().then((data) => {
        setCartData(data);
      }).catch((err) => {
        message.error(err.message);
      }).finally(() => {
        setLoading(false);
      });
  }, [cartVisible]);
 
  const onUpdate = () => {
    getCart().then((data) => {
        setCartData(data);
      }).catch((err) => {
        message.error(err.message);
      })
  }
  const onCheckOut = () => {
    setChecking(true);
    checkout()
      .then(() => {
        message.success("Successfully checkout");
        setCartVisible(false);
      })
      .catch((err) => {
        message.error(err.message);
      })
      .finally(() => {
        setChecking(false);
      });
  };
 
  const onCloseDrawer = () => {
    setCartVisible(false);
  };
 
  const onOpenDrawer = () => {
    setCartVisible(true);
  };
 
  return (
    <>
      <Button type="primary" shape="round" onClick={onOpenDrawer}>
        Cart
      </Button>
      <Drawer
        title="My Shopping Cart"
        onClose={onCloseDrawer}
        visible={cartVisible}
        width={520}
        footer={
          <div
            style={{
              display: "flex",
              justifyContent: "space-between",
            }}
          >
            <Text strong={true}>{`Total price: $${cartData?.totalPrice}`}</Text>
            <div>
              <Button onClick={onCloseDrawer} style={{ marginRight: 8 }}>
                Cancel
              </Button>
              <Button
                onClick={onCheckOut}
                type="primary"
                loading={checking}
                disabled={loading || cartData?.orderItemList.length === 0}
              >
                Checkout
              </Button>
            </div>
          </div>
        }
      >
        <List
          loading={loading}
          itemLayout="horizontal"
          dataSource={cartData?.orderItemList}
          renderItem={(item) => (
            <List.Item>
              <List.Item.Meta
                title={item.menuItem.name}
                description={`$${item.price}`}
              />
              <RemoveItemButton 
              itemId={item.id} 
              updateCart={onUpdate}/>
            </List.Item>
            
          )}
        />
      </Drawer>
    </>
  );
};
 
export default MyCart;