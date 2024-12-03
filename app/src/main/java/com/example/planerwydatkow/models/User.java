package com.example.planerwydatkow.models;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private double balance;

    public User(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }
    public void updateBalance(double amount) {
        this.balance += amount;
    }

}
