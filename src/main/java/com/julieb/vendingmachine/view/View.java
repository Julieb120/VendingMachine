/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.view;

import com.julieb.vendingmachine.dto.Item;
import com.julieb.vendingmachine.dto.Money;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author julie
 */
public class View {
    
    Scanner input = new Scanner (System.in);
    
    public int startBanner(){
        System.out.println("\n=== Vending Machine ===\n"+
                "1. Add Money\n2. Buy Items\n3. Finished");
        int choice = input.nextInt();
        input.nextLine();
        
        return choice;
                
    
    }
    
    public String addMoneyDisplay(){
        System.out.println("How much money would you like to add");
        String amount = input.nextLine();
        return amount;
    }
    
    public void displayMoney(Money money){
        System.out.printf("You now have $%s available", money.getTotal().toString());
    
    }
    public String displayItems(HashMap<String, Item> products){
        for(String product: products.keySet()){
            Item item = products.get(product);
            
         String items = String.format("%s :%s: $%s", item.getCode(), item.getName(), item.getPrice().toString() );
         System.out.println(items);
        }
        
        System.out.println("Item Code: ");
        String choice = input.nextLine();
        input.nextLine();
        
        return choice;
    
    }
    
    public void displayMoneyLeft(Money money){
        if(money == null){
            System.out.printf("You have $0 left");
        }
        
        else{
            System.out.printf("You have $%s left", money.getTotal());
        }
    }
    
    public void exit(Money money){
        System.out.println("=== Thank You ====");
        System.out.println("Here's your change: $" + money.getTotal().toString() ) ;
        System.out.printf("Quarters:%s\n Dimes:%s\n Nickels:%s\n Pennies:%s\n",
                money.getQuarters(), money.getDimes(), money.getNickels(), money.getPennies());
    
    }
    
    
    
    
}
