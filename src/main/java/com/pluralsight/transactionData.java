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


    //formating csv
    public String csvFormat()
    {
        return  date + "|" + description + "|" + vendor + "|" + amount + "|" + type;

    }
}

