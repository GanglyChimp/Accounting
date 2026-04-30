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

}
