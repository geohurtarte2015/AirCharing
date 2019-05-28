/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;


public class ResponseUpdate {
    
    private String  responseCode;
    private String  description;
    
    public ResponseUpdate(String responseCode,String description){
        this.responseCode = responseCode;
        this.description = description;
    }
    public ResponseUpdate(){
          
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
    

    
    
    
    
    
}
