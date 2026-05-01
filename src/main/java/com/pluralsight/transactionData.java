package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class transactionData {

    // these are the fields that make up a single transaction
    LocalDate date;
    LocalTime time;
    String description;
    String vendor;
    double amount;

    // constructor - this runs when we create a new transaction object
    // it takes in all the information and stores it in the fields above
    public transactionData(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // if the amount is positive it is a deposit
    public boolean isDeposit() {
        return amount > 0;
    }

    // if the amount is negative it is a payment
    public boolean isPayment() {
        return amount < 0;
    }

    // getters - these let other classes read the fields without changing them
    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    // toString controls how a transaction looks when we print it
    // the format makes everything line up in neat columns
     public String toString()
     {
        return String.format("%-12s %-10s %-25s %-20s %10.2f",
                date, time, description, vendor, amount);
    }
}

