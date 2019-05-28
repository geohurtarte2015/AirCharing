/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.util.ArrayList;


public class ResponseGetAccountDetailsObject {
    
    
    private String responseCode;    
    private String description;
    private ArrayList<ResponseValue> responseValue;


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

   
    public ArrayList<ResponseValue> getResponseValue() {
        return responseValue;
    }

    
    public void setResponseValue(ArrayList<ResponseValue> responseValue) {
        this.responseValue = responseValue;
    }
   
    
}
