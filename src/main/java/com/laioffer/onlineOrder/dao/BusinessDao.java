package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Authorities;
import com.laioffer.onlineOrder.entity.Business;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Business business) {
        Authorities authorities = new Authorities();
        authorities.setEmail(business.getEmail());
        authorities.setAuthorities("ROLE_BUSINESS");
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(business);
            session.save(authorities);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public Business get(String email) {
        Business business = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Business.class);
            business = (Business) criteria.add(Restrictions.eq("email", email)).uniqueResult();
            Hibernate.initialize(business.getRestaurants());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return business;
    }
}
