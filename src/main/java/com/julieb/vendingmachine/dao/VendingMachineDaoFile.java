/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.dao;

import com.julieb.vendingmachine.dto.Item;
import com.julieb.vendingmachine.dto.Money;
import com.julieb.vendingmachine.service.InsufficientFundsException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author julie
 */
public class VendingMachineDaoFile implements VendingMachineDao {
    HashMap<String,Item> items = new HashMap<>();
    Money total = new Money();

    @Override
    public Money addMoney(BigDecimal amount) {
        Money money = new Money();
        money.setTotal(amount);
        this.total= money;
        return money;
    }

    @Override
    public HashMap<String, Item> getAllItems() {
        readFile();
        return items;
    }

    @Override
    public void buyItems(String code) throws InsufficientFundsException {

       Item purchased = items.get(code);
       
       if (this.total.getTotal().compareTo(purchased.getPrice()) == -1  )
       {
           throw new InsufficientFundsException(); // throw exception if money not enough
       }
       
       //Edit money available
       BigDecimal cost = purchased.getPrice();
       BigDecimal money = this.total.getTotal();
       this.total.setTotal( money.subtract(cost));
       
       //Edit inventory amount
      int current = purchased.getQuantity();
      purchased.setQuantity(current-1);
      
      
      //edit file
      writeFile();
       
    }

    @Override
    public Money returnChange() {
        return this.total;
    }
    
    
    //read file 
    public void readFile() {
        try{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("items.txt")));
        
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            Item item =unmarshalItem(line);
            
            items.put(item.getCode(),item );
        }
        
        }catch(FileNotFoundException ex){}
    }
    
    public Item unmarshalItem(String item){
        String[] elements = item.split(":");
        //code: name: price: quantity
        Item product = new Item();
        product.setCode(elements[0]);
        product.setName(elements[1]);
        
        Double price1 = Double.valueOf(elements[2]);
        BigDecimal price = new BigDecimal(price1);
        product.setPrice(price);
        
        product.setQuantity(Integer.valueOf(elements[3]));
        
        return product;
    }
    
    //write to file
    
    public void writeFile(){
        try{
        PrintWriter write= new PrintWriter(new FileWriter("items.txt"));
        
        for(String item: items.keySet() ){
            write.println(marshalItem(items.get(item)));
        }
        
        write.flush();
        write.close();
        
        }catch (IOException ex){}
    }
    
    public String marshalItem(Item item){
        String write = String.format( "%s:%s:%s:%s", item.getCode(), item.getName(),
                item.getPrice().toString(), String.valueOf(item.getQuantity()) );
    
        return write;
    }
}
