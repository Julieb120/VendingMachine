/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.dao;

import com.julieb.vendingmachine.dto.Item;
import com.julieb.vendingmachine.dto.Money;
import com.julieb.vendingmachine.service.InsufficientFundsException;
import java.math.BigDecimal;
import java.util.HashMap;



/**
 *
 * @author julie
 */
public interface VendingMachineDao {
    
    Money addMoney(BigDecimal amount);
    HashMap<String, Item> getAllItems();
    void buyItems(String code) throws InsufficientFundsException;
    Money returnChange();
}
