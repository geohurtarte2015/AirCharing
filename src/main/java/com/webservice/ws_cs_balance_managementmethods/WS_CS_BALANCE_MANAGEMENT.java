/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.ws_cs_balance_managementmethods;

import com.controller.Operations;
import com.controller.ResponseCodeCharing;
import com.dao.DaoOrigin;
import com.pojo.Refill;
import com.pojo.ResponseBalance;
import com.pojo.ResponseUpdate;
import com.pojo.TbOrigin;
import com.webservice.charing.WsAirInterface;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author LENOVO
 */
@WebService(serviceName = "WS_CS_BALANCE_MANAGEMENT")
public class WS_CS_BALANCE_MANAGEMENT {
    
    private static Operations operations=null;
    private static String responseText="";
    private  DaoOrigin daoOrigin=null;
    private ResponseCodeCharing responseCodeCharing = null;
    
    public WS_CS_BALANCE_MANAGEMENT(){
       if (operations == null) {
           operations = new Operations();     
           responseCodeCharing = new ResponseCodeCharing();
           }         
    }
      
    
    @WebMethod(operationName = "topUpAccount")
    public ResponseBalance topUpAcoount(@WebParam(name = "originId") String origenId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "amount") String amount,@WebParam(name = "externalTransactionType") String ott) {
      
       long startTime = System.currentTimeMillis();
       //System.out.println("Begin : "+startTime);
        ResponseBalance responseRefill = null;   
        
        try {
            //TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(origenId));
            //responseRefill = operations.getRefill(msisdn, origenId, amount,resOrigin.getDescription(),resOrigin.getOtt());
            responseRefill = operations.getRefill(msisdn,amount,origenId,ott);
           
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WsAirInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WsAirInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
       long endTime = System.currentTimeMillis();
       long duration = (endTime - startTime);
       System.out.println("Time duration process: "+(duration)+" milliseconds");
        return responseRefill;
    }
    
     @WebMethod(operationName = "cancelTopUp")
    public ResponseBalance cancelTopUp(@WebParam(name = "originId") String originId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "amount") String amount) {
       
        
        
        ResponseBalance response = new ResponseBalance("0","Successful");
        return  response;
    }
}
