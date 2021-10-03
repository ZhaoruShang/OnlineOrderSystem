package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MenuInfoService {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private RestaurantService restaurantService;

    public List<Restaurant> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    public Set<MenuItem> getAllMenuItem(int restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        return restaurant.getMenuItemList();
    }

    public MenuItem getMenuItem(int id) {
        return menuItemService.get(id);
    }

}
