package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.techelevator.application.PurchaseMenu.userMoney;

public class VendingMachine extends LogWriter {

    public void run() {
        final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss ");
        LocalDateTime ldt = LocalDateTime.now();
        String formattedString = ldt.format(CUSTOM_FORMATTER);
        File cateringFile = new File("catering.csv");
        File otherCateringFile = new File("catering1.csv");
        File auditFile = new File("Audit.txt");
        List<Items> itemsList = new ArrayList<>();
        int itemsPurchased = 0;

        if (cateringFile.exists()) {
            try (Scanner reader = new Scanner(cateringFile)) {
                while (reader.hasNextLine()) {
                    String lineOfText = reader.nextLine();
                    String[] textArray = lineOfText.split(",");
                    Items items = new Items(textArray[0], textArray[1],
                            new BigDecimal(textArray[2]), textArray[3]);
                    itemsList.add(items);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                for (Items eachItem : itemsList) {
                    System.out.println(eachItem);
                }
            } else if (choice.equals("purchase")) {

                    while (true) {
                        UserOutput.displayPurchaseMenu();
                        String purchaseOption = UserInput.getPurchaseMenuOption();

                        if (purchaseOption.equals("pay")) {
                            purchaseOption = UserInput.getFeedMoneyOption();
                        }
                        if (purchaseOption.equals("select")) {
                            for (Items eachItem : itemsList) {
                                System.out.println(eachItem);
                            }
                            String productSlot = UserInput.getSelectOption();

                            for (Items eachItem : itemsList) {
                                if (productSlot.equalsIgnoreCase(eachItem.getButton())) {
                                    int currentQuantity = eachItem.getQuantity();
                                    int newQuantity = currentQuantity - 1;
                                    BigDecimal discountPrice;
                                    String category = eachItem.getCategory();
                                    String message = eachItem.getMessage();

                                    if (itemsPurchased % 2 == 0) {

                                        if (currentQuantity == 0) {
                                            System.out.println("NO LONGER AVAILABLE");
                                        } else if (userMoney.compareTo(eachItem.getPrice()) >= 0) {
                                            userMoney = userMoney.subtract(eachItem.getPrice());
                                            eachItem.setQuantity(newQuantity);
                                            System.out.println(eachItem.getName() + " $" + eachItem.getPrice()
                                                    + " Money remaining: $" + userMoney);
                                            itemsPurchased++;
                                            if (category.equalsIgnoreCase("Munchy")) {
                                                System.out.println("Munchy, Munchy, so good!");
                                            } else if (category.equalsIgnoreCase("Candy")) {
                                                System.out.println("Sugar, Sugar, so sweet!");
                                            } else if (category.equalsIgnoreCase("Drink")) {
                                                System.out.println("Drinky, Drinky, Slurp, Slurp!");
                                            } else if (category.equalsIgnoreCase("Gum")) {
                                                System.out.println("Chewy, Chewy, lots O Bubbles!");
                                            }
                                        } else {
                                            System.out.println("Not enough money.");
                                        }
                                    } else {
                                        discountPrice = eachItem.getPrice().subtract(new BigDecimal("1"));
                                        if (userMoney.compareTo(discountPrice) >= 0) {
                                            userMoney = userMoney.subtract(discountPrice);
                                            eachItem.setQuantity(newQuantity);
                                            System.out.println(eachItem.getName() + " $" + discountPrice
                                                    + " Money remaining: $" + userMoney);
                                            itemsPurchased++;
                                            if (category.equalsIgnoreCase("Munchy")) {
                                                System.out.println("Munchy, Munchy, so good!");
                                            } else if (category.equalsIgnoreCase("Candy")) {
                                                System.out.println("Sugar, Sugar, so sweet!");
                                            } else if (category.equalsIgnoreCase("Drink")) {
                                                System.out.println("Drinky, Drinky, Slurp, Slurp!");
                                            } else if (category.equalsIgnoreCase("Gum")) {
                                                System.out.println("Chewy, Chewy, lots O Bubbles!");
                                            }
                                        } else {
                                            System.out.println("Not enough money.");
                                        }
                                    }
                                }
                            }


                        }
                        if (purchaseOption.equalsIgnoreCase("finish")) {
                            BigDecimal userMoneyTimesHundred = userMoney.multiply(new BigDecimal("100"));
                            int userMoneyCents = userMoneyTimesHundred.intValue();
                            BigDecimal amountDispensed = new BigDecimal("0.00");
                            int dollars = 0;
                            int quarters = 0;
                            int dimes = 0;
                            int nickels = 0;

                            while (userMoneyCents > 0) {
                                if (userMoneyCents >= 100) {
                                    amountDispensed = amountDispensed.add(new BigDecimal("1.00"));
                                    userMoneyCents = userMoneyCents - 100;
                                    userMoney = userMoney.subtract(new BigDecimal("1.00"));
                                    dollars++;
                                } else if (userMoneyCents >= 25) {
                                    amountDispensed = amountDispensed.add(new BigDecimal("0.25"));
                                    userMoneyCents = userMoneyCents - 25;
                                    userMoney = userMoney.subtract(new BigDecimal("0.25"));
                                    quarters++;
                                } else if (userMoneyCents >= 10) {
                                    amountDispensed = amountDispensed.add(new BigDecimal("0.10"));
                                    userMoneyCents = userMoneyCents - 10;
                                    userMoney = userMoney.subtract(new BigDecimal("0.10"));
                                    dimes++;
                                } else if (userMoneyCents >= 5) {
                                    amountDispensed = amountDispensed.add(new BigDecimal("0.05"));
                                    userMoneyCents = userMoneyCents - 5;
                                    userMoney = userMoney.subtract(new BigDecimal("0.05"));
                                    nickels++;
                                } else {
                                    break;
                                }
                            }
                            System.out.println("Your change is: $" + amountDispensed + " (" + dollars +
                                    " dollar(s), " + quarters + " quarter(s), " + dimes + " dime(s), and " +
                                    nickels + " nickel(s).");
                            try (PrintWriter writer = new PrintWriter(new FileOutputStream(auditFile, true))) {
                                writer.println(formattedString + " CHANGE GIVEN: $" + amountDispensed +
                                        "  $" + userMoney);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                } else if (choice.equals("exit")) {
                    System.out.println("Goodbye");
                    break;
                }
            }
        }
    }
