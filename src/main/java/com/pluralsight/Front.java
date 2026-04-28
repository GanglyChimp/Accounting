package com.pluralsight;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Front
{


    static void main(){

    homeScreen();



    }


        static void homeScreen (){


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
                } catch (Exception ex)
                {

                }
            }
}//requirements
           //home screen
            //display welcome
                 //prompt user selection
                      //select 1) 2) 3) menu options
                             //switch loop
                                 //if not then print wrong options.
                          //prompt exit

        // deposite option
        //make payment
        //go to ledger


        //ledger
        //ledger display
        //entries, newist first
        //deposites
        //payments

        //reports
        //reports display
        //month to date
        //previous month
        //year to date
        //previous year
        //search by vendor
        //return to ledger


        //exit
        //prompt the user if they want to exit the program