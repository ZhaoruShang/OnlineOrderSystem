package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import com.laioffer.onlineOrder.service.MenuItemService;
import com.laioffer.onlineOrder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @RequestMapping(value = "/business/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public Set<MenuItem> getRestaurantMenuItems(@PathVariable("restaurantId") int restaurantId) {
        return menuItemService.getAllMenuItemsByRestaurant(restaurantId);
    }

    @RequestMapping(value = "/business/restaurant/{restaurantId}/menu", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenuItem(@RequestBody MenuItem menuItem, @PathVariable("restaurantId") int restaurantId) {
        menuItemService.save(menuItem, restaurantId);
    }

    @RequestMapping(value = "/business/restaurant/{restaurantId}/menu", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRestaurant(@RequestBody MenuItem menuItem, @PathVariable("restaurantId") int restaurantId) {
        menuItemService.update(menuItem, restaurantId);
    }

    @RequestMapping(value = "/business/restaurant/{restaurantId}/menu/{menuitemId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeRestaurant(@PathVariable("restaurantId") int restaurantId, @PathVariable("menuitemId") int menuitemId) {
        menuItemService.remove(menuitemId, restaurantId);
    }
}
