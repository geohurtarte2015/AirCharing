
package com.webservice.ws_cs_payment_operations;

import com.controller.Operations;
import com.pojo.ResponseBalance;
import com.pojo.ResponseUpdate;
import com.pojo.TbOrigin;
import com.webservice.charing.WsAirInterface;
import com.webservice.ws_cs_pospaid_operations.WsCsPosPaidOperations;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


@WebService(serviceName = "WS_CS_PAYMENT_OPERATIONS")
public class WsCsPaymentOperations {
    
    private static Operations operations=null;
    private TbOrigin resOrigin = null;
    
    
    public WsCsPaymentOperations(){
    
          if (operations == null) {
           operations = new Operations();     
            }
          resOrigin = new TbOrigin();            
            this.resOrigin.setIdOrigin(1);
            this.resOrigin.setDescription("PRETUPS");
            this.resOrigin.setOtt("-937");
            this.resOrigin.setMethodList(1);
            this.resOrigin.setState(1);
            this.resOrigin.setOperatorId(1);
    
    }

  
    
    @WebMethod(operationName = "getDebitOperation")
    public ResponseUpdate getDebitOperation(@WebParam(name = "originId") String originId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "ott") String ott,@WebParam(name = "amount") String amount)  {
         System.out.println("Id"+" "+originId+" "+"msisdn" +msisdn+" "+"amount"+" "+amount);
        ResponseUpdate cyclePayment = new ResponseUpdate();
        try {   
            if(resOrigin!=null) {
                cyclePayment = operations.getCyclePaymentDud(originId,msisdn,trxId,amount,resOrigin.getDescription(),ott,resOrigin.getOperatorId());
            } else {
                cyclePayment.setResponseCode("1");
                cyclePayment.setDescription("Fail GetBalance&Date");                
            }          
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(cyclePayment.getDescription());
          return cyclePayment;
    }
    
     @WebMethod(operationName = "getCreditOperation")
    public ResponseBalance getCreditOperation(@WebParam(name = "trxId") String trxId,@WebParam(name = "msisdn") String msisdn, @WebParam(name = "amount") String amount, @WebParam(name = "origenId") String origenId,@WebParam(name = "ott") String ott) {
       
       long startTime = System.currentTimeMillis();
       //System.out.println("Begin : "+startTime);
        ResponseBalance responseRefill = new ResponseBalance();
        
        try {
            //TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(origenId));
            
            responseRefill = operations.getRefill(trxId,msisdn, origenId, amount, ott);
            
            //responseRefill = operations.getRefill(msisdn, origenId, amount,resOrigin.getOtt());

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




}
