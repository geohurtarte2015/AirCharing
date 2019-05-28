/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;


public class ResponseCurrentBalance extends ResponseUpdate{
    
    
    private String usageBalance;
    private String currentBalance;
   

 
    public String getUsageBalance() {
        return usageBalance;
    }

  
    public void setUsageBalance(String usageBalance) {
        this.usageBalance = usageBalance;
    }

   
    public String getCurrentBalance() {
        return currentBalance;
    }

    
    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    
    public String getString(){
    
    return usageBalance+" "+currentBalance;
    }

    
}
