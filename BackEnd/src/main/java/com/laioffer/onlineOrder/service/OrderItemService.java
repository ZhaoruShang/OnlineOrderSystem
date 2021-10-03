package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.OrderItemDao;
import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderItemDao orderItemDao;

    public void saveOrderItem(int menuId) {
        OrderItem orderItem = new OrderItem();
        MenuItem menuItem = menuItemService.get(menuId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Customer customer = customerService.getCustomer(email);
        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());

        orderItemDao.save(orderItem);
    }

    public void removeOrderItem(int orderItemId) {


        orderItemDao.remove(orderItemId);
    }
}
