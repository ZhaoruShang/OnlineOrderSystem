package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.MenuItemDao;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MenuItemService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MenuItemDao menuItemDao;


    public MenuItem get(int menuItemId) {
        return menuItemDao.get(menuItemId);
    }

    public Set<MenuItem> getAllMenuItemsByRestaurant(int restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        //Hibernate.initialize(restaurant.getMenuItemList());
        return restaurant.getMenuItemList();
    }

    public void save(MenuItem menuItem, int restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        menuItem.setRestaurant(restaurant);
        menuItemDao.save(menuItem);
    }

    public void update(MenuItem menuItem, int restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        menuItem.setRestaurant(restaurant);
        menuItemDao.update(menuItem);
    }

    public void remove(int menuItemId, int restaurantId)  {
        menuItemDao.remove(menuItemId);
    }
}
