package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.CartDao;
import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartDao cartDao;

    public Cart getCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Customer customer = customerService.getCustomer(email);

        if (customer != null) {
            Cart cart = customer.getCart();

            double totalPrice = 0.0;

            for (OrderItem orderItem : cart.getOrderItemList()) {
                totalPrice += orderItem.getPrice()* orderItem.getQuantity();
            }
            cart.setTotalPrice(totalPrice);
            return cart;
        }

        return new Cart();
    }

    public void cleanCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Customer customer = customerService.getCustomer(email);

        if (customer != null) {
            Cart cart = customer.getCart();
            cartDao.cleanCart(cart);
            cart.setTotalPrice(0.0);
        }

    }
}
