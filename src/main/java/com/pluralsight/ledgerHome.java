package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ledgerHome {

    // storing the file name here so I dont have to type it out every time I need it
    // if the file name ever changes I only have to update it in one place
    static final String fileName = "transactions.csv";

    // this is the main ledger screen method
    // it takes in the scanner from homeScreen so we can keep using the same one
    // the loop keeps running until the user types H to go back home
    public static void ledgerScreen(Scanner input) {

        // starting choice as empty, the while loop will fill it in
        String choice = "";

        // keep looping until the user types H
        while (!choice.equalsIgnoreCase("H")) {

            // printing the menu options every time the loop runs
            System.out.println("\n========== Ledger ==========");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Enter your choice: ");

            // reading what the user typed and removing any extra spaces
            choice = input.nextLine().trim();

            // converting to uppercase so it works weather the user types
            // upper or lower case letters
            switch (choice.toUpperCase()) {

                case "A":
                    // loading all transactions and sending them to display
                    displayTransactions(newToOldTransactions());
                    break;

                case "D":
                    // loading all transactions but displayDeposits will filter them
                    displayDeposits(newToOldTransactions());
                    break;

                case "P":
                    // loading all transactions but displayPayments will filter them
                    displayPayments(newToOldTransactions());
                    break;

                case "R":
                    // sending the scanner over so reportScreen can also recieve user input
                    // without needing to create a new scanner
                    reportScreen.displayReportsScreen(input);
                    break;

                case "H":
                    // not doing anything here becuase the while loop condition
                    // checks for H and will stop on its own
                    break;

                default:
                    // anything that isnt A D P R or H is not valid
                    System.out.println("\nInvalid option. Please enter A, D, P, R, or H.");
            }
        }
    }

    // this method opens the csv file and reads every line
    // each line becomes a transactionData object and gets added to a list
    // at the end we reverse the list so newest entrys show up first
    public static ArrayList<transactionData> newToOldTransactions() {

        // creating an empty list that we will fill up as we read the file
        ArrayList<transactionData> transactions = new ArrayList<>();

        try {
            // opening the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // the first line is the header row like "date|time|description|vendor|amount"
            // we dont want that in our list so we skip it here
            reader.readLine();

            // reading the first real line of data
            String line = reader.readLine();

            // keep looping as long as there are lines to read
            // when line is null we have reached the end of the file
            while (line != null) {

                // spliting the line by the pipe symbol to separate each piece of data
                // columns[0] = date, columns[1] = time, columns[2] = description
                // columns[3] = vendor, columns[4] = amount
                String[] columns = line.split("\\|");

                // converting each column to the correct data type
                //special thanks to Sasha for demonstrating this column example.
                LocalDate date = LocalDate.parse(columns[0]);
                LocalTime time = LocalTime.parse(columns[1]);
                String description = columns[2];
                String vendor = columns[3];
                double amount = Double.parseDouble(columns[4]);

                // creating a new transactionData object with all the info
                // and adding it to our list
                transactions.add(new transactionData(date, time, description, vendor, amount));

                // reading the next line so the loop keeps moving foward
                // without this it would loop forever on the same line
                line = reader.readLine();
            }

            // always close the file when your done with it
            reader.close();

        } catch (Exception e) {
            // if anything goes wrong reading the file this will print the error
            System.out.println("\nError: " + e.getMessage());
        }

        // reversing the list so the most recent transations show at the top
        Collections.reverse(transactions);
        return transactions;
    }

    // this method prints every single transaction in the list
    // no filtering here, just all of them
    public static void displayTransactions(ArrayList<transactionData> transactions) {
        System.out.println("\n---------- All Transactions ----------");

        // printing the header row so the user knows what each colum means
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n", "Date", "Time", "Description", "Vendor", "Amount");

        // printing a line of dashes to separate the header from the data
        System.out.println("-".repeat(82));

        // looping through every transaction and printing it
        // the toString method in transactionData handles the formatting
        for (transactionData t : transactions) {
            System.out.println(t);
        }
    }

    // this method only prints transactions where the amount is positive
    // isDeposit in transactionData handles that check
    public static void displayDeposits(ArrayList<transactionData> transactions) {
        System.out.println("\n---------- Deposits ----------");

        // same header as displayTransactions so everything looks consistant
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n", "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-".repeat(82));

        for (transactionData t : transactions) {
            // only print this transaction if it is a deposit
            // isDeposit returns true if amount is greater than zero
            if (t.isDeposit()) {
                System.out.println(t);
            }
        }
    }

    // this method only prints transactions where the amount is negitive
    // isPayment in transactionData handles that check
    public static void displayPayments(ArrayList<transactionData> transactions) {
        System.out.println("\n---------- Payments ----------");

        // same header as the other display methods
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n", "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-".repeat(82));

        for (transactionData t : transactions) {
            // only print this transaction if it is a payment
            // isPayment returns true if amount is less than zero
            if (t.isPayment()) {
                System.out.println(t);
            }
        }
    }
}