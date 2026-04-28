package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class homeScreen
{
      try {
    FileReader fileReader = new FileReader("transactions.csv");
    Scanner userInput = new Scanner(System.in);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    while (true) {
        System.out.println("\n===== Home Screen =====");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.print("Choose: ");
        String choice = userInput.nextLine().trim().toUpperCase();

        switch (choice) {
            case "D":
                System.out.println("Add a Deposit");
                //      addDeposit();
                //array
            case "P":
                System.out.println("Make a payment selected");
                //      makePayment();
                //array
            case "L":
                System.out.println("Display My ledger");
                //array
                //      ledgerScreen();
            case "X":

                System.out.println("Goodbye!");
                return;
            // exits homeScreen → ends program

            default:
                System.out.println("Invalid option.");
        }


    }
    //display home screen

} catch (Exception ex) {

}
}
