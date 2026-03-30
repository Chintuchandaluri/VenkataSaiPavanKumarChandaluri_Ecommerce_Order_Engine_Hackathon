package com.service;

import java.util.*;

public class LogService {

    private List<String> logs = new ArrayList<>();

    public void addLog(String message) {

        String log = new Date() + " : " + message;

        logs.add(log);
    }

    public void viewLogs() {

        if (logs.isEmpty()) {
            System.out.println("No logs available");
            return;
        }

        for (String log : logs) {
            System.out.println(log);
        }
    }
}