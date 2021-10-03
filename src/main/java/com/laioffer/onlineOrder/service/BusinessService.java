package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.BusinessDao;
import com.laioffer.onlineOrder.entity.Business;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BusinessService {

    @Autowired
    private BusinessDao businessDAO;

    public void signUp(Business business) {

        business.setRestaurants(new HashSet<>());
        business.setEnabled(true);
        businessDAO.save(business);
    }

    public Business getBusiness(String email) {
        return businessDAO.get(email);
    }
}
