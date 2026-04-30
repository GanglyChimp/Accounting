package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class addDeposite
{
    static final String fileName = "transactions.csv";
    //defining the date and time/  hours:min:seconds
    //formating the date as yyyy-mm--dd
    static final DateTimeFormatter dateClockTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //scanner for userInput
    static Scanner scanner = new Scanner(System.in);
    static void addTransaction(boolean isDeposit) {


       //try and catch to loop adding/ subtracting into account
        try {
            System.out.print("Description: ");
            String description = scanner.nextLine().trim();

            System.out.print("Vendor: ");
            String vendor = scanner.nextLine().trim();

            System.out.print("Amount: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());


            //math call makes it so I can enter positive or negative without making a
            //seperate function

            if (!isDeposit) {
                amount = -Math.abs(amount);
            } else {
                amount = Math.abs(amount);
            }

            //call to the top to format time and date
            String date = LocalDate.now().format(dateTimeFormatter);
            String time = LocalTime.now().format(dateClockTime);


            //splitting information
            String line = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
        }
    }

}
