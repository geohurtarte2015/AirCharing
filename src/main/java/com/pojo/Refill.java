
package com.pojo;

/**
 *
 * @author Edgar Giovanni Hurtarte
 */


public class Refill {
    
    private String originTransactionId;
    private String responseCode;
    
    
    public Refill(){
     
    }
    public Refill(String originTransactionId,String responseCode){
        this.originTransactionId=originTransactionId;
        this.responseCode = responseCode;
    }
    
    
    public String getOriginTransactionId() {
        return originTransactionId;
    }

   
    public void setOriginTransactionId(String originTransactionId) {
        this.originTransactionId = originTransactionId;
    }

   
    
    public String getResponseCode() {
        return responseCode;
    }

    
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getString(){
    
        return originTransactionId+" "+responseCode;
    }
 
    
}
