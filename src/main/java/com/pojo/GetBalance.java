
package com.pojo;

import java.util.ArrayList;


public class GetBalance {
    
    private ArrayList<OfferId>  OfferId;
    private String responseCode;
    private String description;
    
    public GetBalance(){}

 
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

 
    public ArrayList<OfferId> getOfferId() {
        return OfferId;
    }


    public void setOfferId(ArrayList<OfferId> OfferId) {
        this.OfferId = OfferId;
    }


    
}
