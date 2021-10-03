package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.RestaurantDao;
import com.laioffer.onlineOrder.entity.Business;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private BusinessService businessService;

    public List<Restaurant> getAllRestaurants() {

        return restaurantDao.getAllRestaurants();
    }

    //public Set<Restaurant> getAllRestaurantsByBusiness()


    public Restaurant getRestaurant(int restaurantId) {

        for (Restaurant restaurant : getAllRestaurants()) {
            if (restaurant.getId() == restaurantId){
                return restaurant;
            }
        }
        return null;
    }
    public void addRestaurant(Restaurant restaurant) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Business business = businessService.getBusiness(email);

        restaurant.setBusiness(business);

        restaurantDao.save(restaurant);
    }

    public void removeRestaurant(int restaurantId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Business business = businessService.getBusiness(email);
        Restaurant restaurant = restaurantDao.get(restaurantId);
        if (business.getRestaurants().contains(restaurant))
            restaurantDao.remove(restaurantId);
    }

    public void updateRestaurant(Restaurant restaurant) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Business business = businessService.getBusiness(email);

        restaurant.setBusiness(business);

        restaurantDao.update(restaurant);
    }
}
