/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.HashMap;


public final class ResponseCodeCharing {
    
    private HashMap reponse;
    
    
    public ResponseCodeCharing(){    
        this.initCode();
    }


    public HashMap getReponse() {
        return reponse;
    }

  
    public void setReponse(HashMap reponse) {
        this.reponse = reponse;
    }
    
    public void initCode(){
    HashMap objectResponse = new HashMap();
    objectResponse.put(0,"Successful");
    objectResponse.put(1,"Fail GetBalance&Date");
    objectResponse.put(2,"Fail UpdateOffer");
    objectResponse.put(3,"Fail RunPeriodicAccountMng");
    objectResponse.put(4,"Fail UpdateBalance&Date");
    objectResponse.put(5,"Fail UpdateCounters");
    objectResponse.put(6,"Update Error");
    objectResponse.put(7,"Payment Error");
    objectResponse.put(8,"Invalid Amount Payment");
    objectResponse.put(9,"Invalid originID"); 
    objectResponse.put(100,"Other Error");
    objectResponse.put(101,"Not used");      
    objectResponse.put(102,"Subscriber not found");  
    objectResponse.put(103,"Account barred from refill");  
    objectResponse.put(104,"Temporary blocked");  
    objectResponse.put(105,"Dedicated account not allowed");  
    objectResponse.put(106,"Dedicated account negative");  
    objectResponse.put(107,"Voucher status used by same");  
    objectResponse.put(108,"Voucher status used by different");  
    objectResponse.put(109,"Voucher status unavailable");  
    objectResponse.put(110,"Voucher status expired");  
    objectResponse.put(111,"Voucher status stolen or missing");  
    objectResponse.put(112,"Voucher status damaged");  
    objectResponse.put(113,"Voucher status pending");  
    objectResponse.put(114,"Voucher type not accepted");  
    objectResponse.put(115,"Refill not accepted");   
    objectResponse.put(117,"Service class change not allowed");  
    objectResponse.put(119,"Invalid voucher activation code");  
    objectResponse.put(120,"Invalid refill profile");  
    objectResponse.put(121,"Supervision period too long");  
    objectResponse.put(122,"Service fee period too long");  
    objectResponse.put(123,"Max credit limit exceeded");  
    objectResponse.put(124,"Below minimum balance");      
    objectResponse.put(126,"Account not active");  
    objectResponse.put(127,"Accumulator not available");  
    objectResponse.put(128,"Invalid PIN code");  
    objectResponse.put(129,"Faf number does not exist");  
    objectResponse.put(130,"Faf number not allowed"); 
    objectResponse.put(133,"Service class list empty");  
    objectResponse.put(134,"Accumulator overflow");  
    objectResponse.put(135,"Accumulator underflow");  
    objectResponse.put(136,"Date adjustment error");  
    objectResponse.put(137,"Get balance and date not allowed");  
    objectResponse.put(138,"No PIN code registered");  
    objectResponse.put(139,"Dedicated account not defined");  
    objectResponse.put(140,"Invalid old Service Class");  
    objectResponse.put(141,"Invalid language");  
    objectResponse.put(142,"Subscriber already installed");  
    objectResponse.put(143,"Invalid master subscriber");  
    objectResponse.put(144,"Subscriber already activated");  
    objectResponse.put(145,"Already linked subordinate");  
    objectResponse.put(146,"Already linked as master");  
    objectResponse.put(147,"Invalid old community list");  
    objectResponse.put(148,"Invalid new community list");  
    objectResponse.put(149,"Invalid promotion plan end date");  
    objectResponse.put(150,"Invalid promotion plan. The promotion plan allocation was invalid.");  
    objectResponse.put(151,"Promotion plan not found");  
    objectResponse.put(152,"Deblocking of expired account");  
    objectResponse.put(153,"Dedicated account max credit limit exceeded");  
    objectResponse.put(154,"Invalid old SC date");  
    objectResponse.put(155,"Invalid new service class");  
    objectResponse.put(156,"Delete subscriber failed due to for example references to consumers exist at the provider.");     
    objectResponse.put(197,"Periodic account management evaluation failed");    
    objectResponse.put(260,"Capability not available");    
    objectResponse.put(266,"Permission denied");    
    objectResponse.put(999,"Other error No retry");    
    this.setReponse(objectResponse);
    }


    
}
