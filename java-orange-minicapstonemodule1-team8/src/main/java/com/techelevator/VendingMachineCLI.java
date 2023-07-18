package com.techelevator;

import com.techelevator.application.Items;
import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineCLI 
{
//    public static List<Items> itemsList = new ArrayList<>();
    public static void main(String[] args) 
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();
//        String userChoice = UserInput.getItemOptions(itemsList);
//        if(userChoice.equalsIgnoreCase("U-Chews")){
//            itemsList.get(0).setQuantity(itemsList.get(0).getQuantity().subtract(new BigDecimal("1")));
////            userMoney = userMoney.subtract(itemsList.get(0).getPrice());
//        }

    }
    
}
