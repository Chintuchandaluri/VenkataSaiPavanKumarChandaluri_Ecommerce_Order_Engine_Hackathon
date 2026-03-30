package com.service;

import com.model.Product;
import java.util.*;

public class ProductService {

    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {

        products.put(product.getId(), product);

        System.out.println("Product Added Successfully");
    }

    public void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }

        for (Product p : products.values()) {

            System.out.println(
                    p.getId() + " | "
                            + p.getName() + " | "
                            + p.getPrice() + " | "
                            + p.getStock());
        }
    }

    public Product getProduct(int id) {
        return products.get(id);
    }
    public void lowStockAlert() {

        for (Product p : products.values()) {

            if (p.getStock() <= 5) {

                System.out.println("Low Stock: " +
                        p.getName() +
                        " Remaining: " +
                        p.getStock());
            }
        }
    }
}