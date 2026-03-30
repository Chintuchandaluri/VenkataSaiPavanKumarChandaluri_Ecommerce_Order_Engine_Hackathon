package com.model;

import java.util.*;

public class Order {

    private int orderId;
    private List<CartItem> items;
    private double totalAmount;
    private String status;

    public Order(int orderId, List<CartItem> items, double totalAmount) {
        this.orderId = orderId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = "PLACED";
    }

    public int getOrderId() {
        return orderId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}