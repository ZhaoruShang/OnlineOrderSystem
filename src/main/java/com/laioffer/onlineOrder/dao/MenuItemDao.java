package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Business;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(MenuItem menuItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(menuItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public void remove(int menuItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            MenuItem menuItem = session.get(MenuItem.class, menuItemId);
            session.beginTransaction();
            session.delete(menuItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(MenuItem menuItem) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(menuItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public MenuItem get(int menuItemId) {
        Session session = sessionFactory.openSession();
        try {
            MenuItem menuItem = session.get(MenuItem.class, menuItemId);
            if (menuItem != null) return menuItem;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }
}
