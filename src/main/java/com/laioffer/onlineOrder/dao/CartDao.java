package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    private void removeCartItem(int cartItemId) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            OrderItem orderItem = session.get(OrderItem.class, cartItemId);
            Cart cart = orderItem.getCart();
            cart.getOrderItemList().remove(orderItem);

            session.beginTransaction();
            session.delete(orderItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void cleanCart(Cart cart) {
        for (OrderItem orderItem : cart.getOrderItemList()) {
            removeCartItem(orderItem.getId());
        }
    }
}
