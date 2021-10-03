package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.Business;
import com.laioffer.onlineOrder.entity.Restaurant;
import com.laioffer.onlineOrder.service.BusinessService;
import com.laioffer.onlineOrder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/business/restaurant", method = RequestMethod.GET)
    @ResponseBody
    public Set<Restaurant> getRestaurants() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Business business = businessService.getBusiness(email);
        return business.getRestaurants();
    }

    @RequestMapping(value = "/business/restaurant", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @RequestMapping(value = "/business/restaurant", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.updateRestaurant(restaurant);
    }

    @RequestMapping(value = "/business/restaurant/{restaurantId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeRestaurant(@PathVariable("restaurantId") int restaurantId) {
        restaurantService.removeRestaurant(restaurantId);
    }
}
