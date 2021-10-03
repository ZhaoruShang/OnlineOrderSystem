package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.*;
import com.laioffer.onlineOrder.service.MenuItemService;
import com.laioffer.onlineOrder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class MenuInfoController {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value="/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public Set<MenuItem> getMenus(@PathVariable("restaurantId") int restaurantId) {
        return menuItemService.getAllMenuItemsByRestaurant(restaurantId);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }
}
