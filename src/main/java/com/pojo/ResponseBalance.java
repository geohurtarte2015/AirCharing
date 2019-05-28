/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.util.UUID;


public class ResponseBalance {


    private String  responseCode;
    private String  description;
    private String  trxIDR;
    
    public ResponseBalance(String responseCode,String description){
        this.responseCode = responseCode;
        this.description = description;
        this.trxIDR = UUID.randomUUID().toString();    
    }
    
    public ResponseBalance(){
          
    }


    public String getResponseCode() {
        return responseCode;
    }

   
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    
    public String getDescription() {
        return description;
    }

   
    public void setDescription(String description) {
        this.description = description;
    }
    
        
    public String getString(){
    return responseCode+" "+description;
    }
    
    public String getTrxIDR() {
        return trxIDR;
    }

   
    public void setTrxIDR(String trxIDR) {
        this.trxIDR = trxIDR;
    }
    
    
}
