package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseMenu extends VendingMachine{
    private static Scanner scanner = new Scanner(System.in);

    public static BigDecimal userMoney = new BigDecimal("0");

    public void run() {



        while (true) {
            UserOutput.displayPurchaseMenu();
            String choice = UserInput.getPurchaseMenuOption();

            if (choice.equals("pay")) {
                UserInput.getFeedMoneyOption();

            } else if (choice.equals("select")) {
                System.out.println();
            } else if (choice.equals("finish")) {
                System.out.println();
                break;
            }
        }
    }
}
