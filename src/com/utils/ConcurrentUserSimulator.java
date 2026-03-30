package com.utils;

public class ConcurrentUserSimulator {

    public void simulateUsers() {

        Runnable userTask = () -> {

            String name = Thread.currentThread().getName();

            System.out.println(name + " is placing an order...");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            System.out.println(name + " finished order");
        };

        Thread t1 = new Thread(userTask, "User-1");
        Thread t2 = new Thread(userTask, "User-2");
        Thread t3 = new Thread(userTask, "User-3");

        t1.start();
        t2.start();
        t3.start();
    }
}