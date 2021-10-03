package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public OrderItem get(int orderItemId) {
        Session session = sessionFactory.openSession();
        try {
            OrderItem orderItem = session.get(OrderItem.class, orderItemId);
            if (orderItem != null) return orderItem;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }
    public void save(OrderItem orderItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(orderItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if(session != null) session.close();
        }
    }

    public void remove(int orderItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderItem orderItem = get(orderItemId);
            Cart cart = orderItem.getCart();
            cart.getOrderItemList().remove(orderItem);
            session.beginTransaction();
            session.delete(orderItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(OrderItem orderItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(orderItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }
}
