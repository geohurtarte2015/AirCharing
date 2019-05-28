/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;


public class ResponseGetAccountDetails {
    
    
    private String responseCode;
    private String responseValue;
    private String description;


    public String getDescription() {
        return description;
    }

   
    public void setDescription(String description) {
        this.description = description;
    }

    
    
    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public String getResponseValue() {
        return responseValue;
    }

   
    public void setResponseValue(String responseValue) {
        this.responseValue = responseValue;
    }
    
   
    
}
