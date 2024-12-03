package com.example.planerwydatkow.models;

import java.io.Serializable;

public class Expense implements Serializable {
    private String description; // Description of the expense
    private double amount; // Total amount of the expense
    private String paidBy; // Name of the user who paid


    public Expense(String description, double amount, String paidBy) {
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;

    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaidBy() {
        return paidBy;
    }




}