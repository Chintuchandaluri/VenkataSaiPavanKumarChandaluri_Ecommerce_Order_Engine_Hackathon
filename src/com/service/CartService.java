package com.service;

import com.model.CartItem;
import com.model.Product;

import java.util.*;

public class CartService {

    private Map<Integer, CartItem> cart = new HashMap<>();

    public void addToCart(Product product, int quantity) {

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        if (product.getStock() < quantity) {
            System.out.println("Not enough stock");
            return;
        }

        if (cart.containsKey(product.getId())) {

            CartItem item = cart.get(product.getId());
            item.setQuantity(item.getQuantity() + quantity);

        } else {

            cart.put(product.getId(), new CartItem(product, quantity));
        }

        System.out.println("Product added to cart");
    }

    public void removeFromCart(int productId) {

        if (cart.containsKey(productId)) {

            cart.remove(productId);
            System.out.println("Product removed from cart");

        } else {

            System.out.println("Product not in cart");
        }
    }

    public void viewCart() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double total = 0;

        for (CartItem item : cart.values()) {

            Product p = item.getProduct();

            double price = p.getPrice() * item.getQuantity();

            total += price;

            System.out.println(
                    p.getId() + " | " +
                    p.getName() + " | Qty: " +
                    item.getQuantity() + " | Price: " + price);
        }

        System.out.println("Total = " + total);
    }

    public Map<Integer, CartItem> getCartItems() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
}