package com.service;

public class CouponService {

    private double discount = 0;

    public void applyCoupon(String code) {

        if (code.equalsIgnoreCase("SAVE10")) {

            discount = 0.10;
            System.out.println("10% coupon applied");

        } else if (code.equalsIgnoreCase("SAVE20")) {

            discount = 0.20;
            System.out.println("20% coupon applied");

        } else {

            System.out.println("Invalid coupon");
        }
    }

    public double applyDiscount(double total) {

        return total - (total * discount);
    }

    public void resetCoupon() {
        discount = 0;
    }
}