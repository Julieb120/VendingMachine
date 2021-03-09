/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.service;

import com.julieb.vendingmachine.dao.VendingMachineDaoFile;
import com.julieb.vendingmachine.dto.Item;
import com.julieb.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author julie
 */
public class ServiceImpl implements Service{
    VendingMachineDaoFile dao = new VendingMachineDaoFile();

    @Override
    public Money addMoney(String amount) {
        BigDecimal total = new BigDecimal(amount);
        return dao.addMoney(total);
        
    }

    @Override
    public HashMap<String, Item> getAllItems() {
        //don't display items with inventory < 0
        HashMap<String, Item> allItems = dao.getAllItems();
        HashMap<String, Item> editedItems = new HashMap<>();
        
        for(String item:allItems.keySet() ){
            Item current = allItems.get(item);
            
            if(current.getQuantity() > 0)
            {
                editedItems.put(item, current );
            }
        }
        return editedItems;
    }

    @Override
    public Money buyItems(String code) {
        try{
            dao.buyItems(code);
            return dao.returnChange();
        }
        catch (InsufficientFundsException ex){}
        
        return null;
    }

    @Override
    public Money returnChange() {
        return dao.returnChange();
    }
    
}
