/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.service;

/**
 *
 * @author julie
 */
public class InsufficientFundsException extends Exception {
    
    public InsufficientFundsException(){
        super("You don't have enough for this transaction");
    }
}
