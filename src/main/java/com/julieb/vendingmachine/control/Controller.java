/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.control;

import com.julieb.vendingmachine.service.Service;
import com.julieb.vendingmachine.service.ServiceImpl;
import com.julieb.vendingmachine.view.View;

/**
 *
 * @author julie
 */
public class Controller {
    View view = new View();
    Service service = new ServiceImpl();
    
    
    public void run (){
        boolean running = true;
        
        while (running){
            int choice=menu();
            
            switch(choice){

                case 1:
                    addMoney();
                    break;

                case 2:
                    purchaseItem();
                    break;

                case 3:
                    exit();
                    running = false;
                    break;
            }
        }        
    }
    
    public int menu (){
        return view.startBanner();
        
    }
    
    public void addMoney(){
        String inputAmount = view.addMoneyDisplay();
        view.displayMoney(service.addMoney(inputAmount));
    
    }
    
    public void purchaseItem(){
        String code = view.displayItems(service.getAllItems());
        view.displayMoneyLeft(service.buyItems(code));
    }
    
    public void exit(){
        view.exit(service.returnChange());
    
    }
}
