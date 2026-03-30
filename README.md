# VenkataSaiPavanKumarChandaluri_Ecommerce_Order_Engine_Hackathon
# Ecommerce Order Engine (CLI)

## 1. Project Overview

The Ecommerce Order Engine is a Command Line Interface (CLI) based application developed using Core Java.
This system simulates the working of a simple e-commerce platform where users can manage products, add items to a cart, apply coupons, place orders, and manage orders.

The project demonstrates important Java concepts such as Object-Oriented Programming (OOP), Java Collections, Multithreading, and Exception Handling.

The application runs in the terminal and allows users to interact through a menu-driven interface.

---

## 2. Features Implemented

The application provides the following CLI menu options:

1. Add Product
2. View Products
3. Add To Cart
4. Remove From Cart
5. View Cart
6. Apply Coupon
7. Place Order
8. Cancel Order
9. View Orders
10. Low Stock Alert
11. Return Product
12. Simulate Concurrent Users
13. View Logs
14. Trigger Failure Mode
15. Exit

---

## 3. Design Approach

The project is designed using a modular structure with different layers.

### Model Layer

This layer contains the data classes:

* Product
* CartItem
* Order

### Service Layer

This layer handles the business logic of the application:

* ProductService – manages products
* CartService – manages cart operations
* OrderService – manages order placement and cancellation
* CouponService – handles discount coupons
* LogService – records system logs

### Utility Layer

This layer provides additional system functionalities:

* ConcurrentUserSimulator – simulates multiple users placing orders at the same time using threads
* FailureSimulator – simulates system failures for testing

The application stores data using Java Collections such as ArrayList and HashMap.

---

## 4. Assumptions

The following assumptions were made while developing the system:

* All data is stored in memory (no database is used).
* Two coupon codes are supported:

  * SAVE10 → 10% discount
  * SAVE20 → 20% discount
* Stock quantity decreases when an order is placed.
* Returned products increase the stock quantity.
* Low stock alert is triggered when product quantity is low.
* Logs are generated during system operations.

---

## 5. How to Run the Project

Step 1: Clone the repository

git clone <repository-url>

Step 2: Open the project in any Java IDE such as Eclipse, IntelliJ IDEA, or VS Code.

Step 3: Navigate to the Main.java file.

Step 4: Run the Main.java file.

Step 5: The CLI menu will appear in the terminal where you can select options and test the application.

---

Author:
Venkata Sai Pavan Kumar Chandaluri
