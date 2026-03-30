package com.utils;

public class FailureSimulator {

    public void triggerFailure() {

        System.out.println("Simulating payment failure...");

        try {

            int result = 10 / 0;

        } catch (Exception e) {

            System.out.println("Failure occurred: " + e.getMessage());
        }
    }
}