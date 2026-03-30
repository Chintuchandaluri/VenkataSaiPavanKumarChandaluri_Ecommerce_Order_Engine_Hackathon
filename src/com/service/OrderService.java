package com.service;

import com.model.*;

import java.util.*;

public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    public void placeOrder(Map<Integer, CartItem> cart, CouponService couponService) {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double total = 0;

        List<CartItem> items = new ArrayList<>();

        for (CartItem item : cart.values()) {

            Product p = item.getProduct();

            double price = p.getPrice() * item.getQuantity();

            total += price;

            p.setStock(p.getStock() - item.getQuantity());

            items.add(item);
        }

        total = couponService.applyDiscount(total);

        Order order = new Order(orderCounter++, items, total);

        orders.add(order);

        System.out.println("Order placed successfully");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Final Amount: " + total);
    }

    public void cancelOrder(int orderId) {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {

                order.setStatus("CANCELLED");

                System.out.println("Order cancelled");

                return;
            }
        }

        System.out.println("Order not found");
    }

    public void viewOrders() {

        if (orders.isEmpty()) {

            System.out.println("No orders found");
            return;
        }

        for (Order order : orders) {

            System.out.println(
                    "OrderID: " + order.getOrderId()
                    + " | Total: " + order.getTotalAmount()
                    + " | Status: " + order.getStatus());
        }
    }
    public void returnProduct(int orderId) {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {

                order.setStatus("RETURNED");

                System.out.println("Product returned successfully");

                return;
            }
        }

        System.out.println("Order not found");
    }
}