/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.service;

import com.julieb.vendingmachine.dto.Item;
import com.julieb.vendingmachine.dto.Money;
import java.util.HashMap;

/**
 *
 * @author julie
 */
public interface Service {
    Money addMoney(String amount);
    HashMap<String, Item> getAllItems();
    Money buyItems(String code);
    Money returnChange();
    
    
}
