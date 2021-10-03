package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenuItemToCart(@PathVariable("menuId") int menuId) {
        orderItemService.saveOrderItem(menuId);
    }

    @RequestMapping(value = "/order/{orderItemId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeMenuItemFromCart(@PathVariable("orderItemId") int orderItemId) {
        orderItemService.removeOrderItem(orderItemId);
    }
}
