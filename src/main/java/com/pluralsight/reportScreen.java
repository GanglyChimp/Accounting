package com.pluralsight;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class reportScreen {

    // this is the main reports screen method
    // it takes in the scanner from ledgerHome so I can keep using the same one
    public static void displayReportsScreen(Scanner input) {

        // using a boolean to control the loop instead of while true
        // this way I can just set it to false when I want to exit
        boolean inReports = true;

        while (inReports) {

            // printing the menu every time the loop runs so the user
            // always knows what options they have
            System.out.println("\n========== Reports ==========");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Enter your choice: ");

            // converting the input to an int so I can use it to index into the arrays below
            int choice = Integer.parseInt(input.nextLine().trim());

            // grabbing todays date from the system
            // I use this as a reference point for all the date calculations
            LocalDate today = LocalDate.now();

            // YearMonth makes it easy to get the first and last day of a month
            YearMonth lastMonth = YearMonth.from(today).minusMonths(1);

            // startDates holds the beginning date for each report minus 1
            LocalDate[] startDates = {
                    today.withDayOfMonth(1),
                    lastMonth.atDay(1),
                    today.withDayOfYear(1),
                    LocalDate.of(today.getYear() - 1, 1, 1)
            };

            // endDates has to line up with startDates so index 0 start goes with index 0 end
            LocalDate[] endDates = {
                    today,
                    lastMonth.atEndOfMonth(),
                    today,
                    LocalDate.of(today.getYear() - 1, 12, 31)
            };

        }

    }
}