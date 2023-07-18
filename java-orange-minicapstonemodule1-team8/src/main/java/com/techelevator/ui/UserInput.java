package com.techelevator.ui;

import com.techelevator.application.Items;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import static com.techelevator.application.PurchaseMenu.userMoney;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equalsIgnoreCase("d")) {
            return "display";
        } else if (option.equalsIgnoreCase("p")) {
            return "purchase";
        } else if (option.equalsIgnoreCase("e")) {
            return "exit";
        }

        return "";
    }

    public static String getPurchaseMenuOption() {

        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: $" + userMoney);

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equalsIgnoreCase("m")) {
            return "pay";
        } else if (option.equalsIgnoreCase("s")) {
            return "select";
        } else if (option.equalsIgnoreCase("f")) {
            return "finish";
        }

        return "";
    }

    public static String getFeedMoneyOption() {
        System.out.println("Please enter your money($1, $5, $10, $20 or D(done)): ");
        String addedMoney = scanner.nextLine();
        if (addedMoney.equals("1")) {
            userMoney = userMoney.add(new BigDecimal("1.00"));
            System.out.println("Current money: $" + userMoney);
            return UserInput.getFeedMoneyOption();
        } else if (addedMoney.equals("5")) {
            userMoney = userMoney.add(new BigDecimal("5.00"));
            System.out.println("Current money: $" + userMoney);
            return UserInput.getFeedMoneyOption();
        } else if (addedMoney.equals("10")) {
            userMoney = userMoney.add(new BigDecimal("10.00"));
            System.out.println("Current money: $" + userMoney);
            return UserInput.getFeedMoneyOption();
        } else if (addedMoney.equals("20")) {
            userMoney = userMoney.add(new BigDecimal("20.00"));
            System.out.println("Current money: $" + userMoney);
            return UserInput.getFeedMoneyOption();
        } else if(addedMoney.equalsIgnoreCase("d")) {
            return "select";
        } else {
            System.out.println("Invalid.");
            System.out.println("Current money: $" + userMoney);
            return UserInput.getFeedMoneyOption();
        }
//        try(PrintWriter writer = new PrintWriter(new FileOutputStream(auditFile))){
//            writer.println(LocalDateTime.now() + "MONEY FED:    " + addedMoney + "   "
//                    + userMoney);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

        public static String getSelectOption(){
            System.out.println("What would you like to purchase?: ");
            String selectItem = scanner.nextLine();

            return selectItem;
        }
        }
