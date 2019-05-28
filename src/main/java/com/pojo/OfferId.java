
package com.pojo;

/**
 *
 * @author Edgar Giovanni Hurtarte
 */
public class OfferId {
    
    private String id;
    private int amount;
    private String expiryDateTime;
 
    
    public OfferId(){}
    
    public OfferId(String id,int amount,String expiryDateTime){
        this.id=id;
        this.amount = amount;
        this.expiryDateTime = expiryDateTime;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public int getAmount() {
        return amount;
    }

 
    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getExpiryDateTime() {
        return expiryDateTime;
    }

  
    public void setExpiryDateTime(String expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }


    
}
