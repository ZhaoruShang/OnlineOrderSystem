package com.laioffer.onlineOrder.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {
    private static final long serialVersionUID = -3804795289580568448L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double totalPrice;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

    public Set<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(Set<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
