package com.pluralsight;

public class transactionData
{
    // defining method
    String date;
    String description;
    String vendor;
    double amount;
    String type;


    //creating constructors
    public transactionData( String date, String description, String vendor, double amount, String type)
    {
        this.date = date;
        this.description = description;
        this.vendor = vendor;
        this.amount=amount;
        this.type = type;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //formating csv
    public String csvFormat()
    {
        return  date + "|" + description + "|" + vendor + "|" + amount + "|" + type;

    }
}

