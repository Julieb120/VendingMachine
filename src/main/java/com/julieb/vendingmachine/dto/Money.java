/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julieb.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 * @author julie
 */
public class Money {
    BigDecimal total;
    BigDecimal quarters;
    BigDecimal dimes;
    BigDecimal nickels;
    BigDecimal pennies;

    
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getQuarters() {
        BigDecimal divisor = new BigDecimal("4");
        this.quarters = total.divide(divisor,RoundingMode.HALF_DOWN);
        return quarters;
    }

   
    public BigDecimal getDimes() {
        BigDecimal divisor = new BigDecimal("10");
        this.dimes = total.divide(divisor,RoundingMode.HALF_DOWN);
        return dimes;
    }
    
    public BigDecimal getNickels() {
        BigDecimal divisor = new BigDecimal("20");
        this.nickels = total.divide(divisor,RoundingMode.HALF_DOWN);
        return nickels;
    }


    public BigDecimal getPennies() {
        BigDecimal divisor = new BigDecimal("100");
        this.pennies = total.divide(divisor,RoundingMode.HALF_DOWN);
        return pennies;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.total);
        hash = 61 * hash + Objects.hashCode(this.quarters);
        hash = 61 * hash + Objects.hashCode(this.dimes);
        hash = 61 * hash + Objects.hashCode(this.nickels);
        hash = 61 * hash + Objects.hashCode(this.pennies);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Money other = (Money) obj;
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.quarters, other.quarters)) {
            return false;
        }
        if (!Objects.equals(this.dimes, other.dimes)) {
            return false;
        }
        if (!Objects.equals(this.nickels, other.nickels)) {
            return false;
        }
        if (!Objects.equals(this.pennies, other.pennies)) {
            return false;
        }
        return true;
    }
    
    
}
