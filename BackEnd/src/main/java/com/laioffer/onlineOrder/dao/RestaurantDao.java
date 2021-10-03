package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Business;
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
public class RestaurantDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*
    public Restaurant getRestaurant(int restaurantId) {
        Session session = sessionFactory.openSession();
        try {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) return restaurant;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }
   */


    public List<Restaurant> getAllRestaurants() {
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

    public Restaurant get(int restaurantId) {
        Session session = sessionFactory.openSession();
        try {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) return restaurant;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    public void save(Restaurant restaurant) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(restaurant);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public void remove(int restaurantId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
           // Business business = restaurant.getBusiness();
           // business.getRestaurants().remove(restaurant);

            session.beginTransaction();
            session.delete(restaurant);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(Restaurant restaurant) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(restaurant);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }
}
