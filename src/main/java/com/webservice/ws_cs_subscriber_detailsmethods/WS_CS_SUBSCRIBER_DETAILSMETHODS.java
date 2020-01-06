/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.ws_cs_subscriber_detailsmethods;

import com.controller.Operations;

import com.pojo.ResponseGetAccountDetails;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


@WebService(serviceName = "WS_CS_SUBSCRIBER_DETAILS")
public class WS_CS_SUBSCRIBER_DETAILSMETHODS {
    
    private static Operations operations=null;
    private static String responseText="";

    
     public WS_CS_SUBSCRIBER_DETAILSMETHODS(){
            if (operations == null) {
           operations = new Operations();     
       }     
          
    
    }

 
   
    @WebMethod(operationName = "getServiceClass")
    public ResponseGetAccountDetails getServiceClass(@WebParam(name = "originId") String originId, @WebParam(name = "msisdn") String msisdn) {        
          ResponseGetAccountDetails response = new ResponseGetAccountDetails();      
        try {
            response = operations.getAccountDetailServiceClassCurrent(msisdn, originId);         
        } catch (ParserConfigurationException | SAXException ex) {
            System.out.println("Error "+ex);
        }
        return response; 
    }
    
    
    @WebMethod(operationName = "getActivationDate")
    public ResponseGetAccountDetails getActivationDate(@WebParam(name = "originId") String originId, @WebParam(name = "msisdn") String msisdn) {        
             ResponseGetAccountDetails response = new ResponseGetAccountDetails();      
        try {
            response = operations.getActivationDate(msisdn, originId);
         
        } catch (ParserConfigurationException | SAXException ex) {
            System.out.println("Error "+ex);

        }
        return response;
 
    }
  
       
    @WebMethod(operationName = "getOfferDetails")
    public ResponseGetAccountDetails getOfferDetails(@WebParam(name = "originId") String originId, @WebParam(name = "msisdn") String msisdn,@WebParam(name = "offerId") String offerId) {        
          ResponseGetAccountDetails response = new ResponseGetAccountDetails();      
        try {
            response = operations.getOfferDetails(msisdn, originId,offerId);         
        } catch (ParserConfigurationException | SAXException ex) {
            System.out.println("Error "+ex);
        }
        return response; 
    }
    
    
    @WebMethod(operationName = "getAllOfferDetails")
    public ResponseGetAccountDetails getAllOfferDetails(@WebParam(name = "originId") String originId, @WebParam(name = "msisdn") String msisdn) {        
             ResponseGetAccountDetails response = new ResponseGetAccountDetails();      
        try {
            response = operations.getActivationDate(msisdn, originId);
         
        } catch (ParserConfigurationException | SAXException ex) {
            System.out.println("Error "+ex);

        }
        return response;
 
    }
  
    
}
