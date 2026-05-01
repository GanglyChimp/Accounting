package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ledgerHome
{

    static final String fileName = "transactions.csv";
 {
        String choice = "";

        while (!choice.equalsIgnoreCase("H")) {

            System.out.println("\n========== Ledger ==========");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Enter your choice: ");

            choice = input.nextLine().trim();

            switch (choice.toUpperCase()) {
                case "A":
                    displayTransactions(newToOldTransactions());
                    break;
                case "D":
                    displayDeposits(newToOldTransactions());
                    break;
                case "P":
                    displayPayments(newToOldTransactions());
                    break;
                case "R":
                    reportScreen.displayreportsScreen(input);
                    break;
                case "H":
                    break;
                default:
                    System.out.println("\nInvalid option. Please enter A, D, P, R, or H.");
            }
        }
    }

