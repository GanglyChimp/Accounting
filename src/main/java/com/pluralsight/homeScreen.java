package com.pluralsight;

import java.io.*;

import java.util.Scanner;

public class homeScreen
{

    static void homePage()
  {        try {

            //welcome display
            System.out.println("==============================");
            System.out.println("  Welcome to Accounting App");
            System.out.println("==============================");



          Scanner userInput = new Scanner(System.in);


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
                      addDeposite.addTransaction(false);
                      break;
                  case "P":
                      System.out.println("Make a payment selected");
                      addDeposite.addTransaction(false);
                      break;
                  case "L":
                      System.out.println("Display My ledger");
                      ledgerHome.ledgerScreen(userInput);
                      break;
                  case "X":

                      System.out.println("Goodbye!");
                      return;
                  // exits homeScreen → ends program

                  default:
                      System.out.println("Invalid option.");
              }


          }
        }catch(Exception ex)
          {

          }
  }

 }
