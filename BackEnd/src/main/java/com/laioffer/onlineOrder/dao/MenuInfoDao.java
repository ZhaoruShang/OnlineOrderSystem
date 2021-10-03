package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class MenuInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurant() {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Restaurant.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return new ArrayList<>();
    }

    public Set<MenuItem> getAllMenuItem(int restaurantId) {
        Session session = sessionFactory.openSession();
        try {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) return restaurant.getMenuItemList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return new HashSet<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
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
