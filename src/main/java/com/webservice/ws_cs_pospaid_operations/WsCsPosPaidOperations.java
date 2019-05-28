
package com.webservice.ws_cs_pospaid_operations;

import com.controller.Operations;
import com.dao.DaoOrigin;
import com.pojo.ResponseCurrentBalance;
import com.pojo.ResponseUpdate;
import com.pojo.TbOrigin;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



@WebService(serviceName = "WS_CS_POSPAID_OPERATIONS")
public class WsCsPosPaidOperations {
    
    private static Operations operations=null;
    private static String responseText="";
    private  DaoOrigin daoOrigin=null;

    public WsCsPosPaidOperations(){
            if (operations == null) {
           operations = new Operations();     
       }     
           daoOrigin= new DaoOrigin();
           List<TbOrigin> origins = daoOrigin.listAll();
           daoOrigin= new DaoOrigin();   
    
    }
    
    @WebMethod(operationName = "credit_limit_update_amount")
    public ResponseUpdate creditLimitUpdateAmount(@WebParam(name = "originId") String originId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "amount") String amount) throws ParserConfigurationException, SAXException {
    System.out.println("Id"+" "+originId+" "+"msisdn" +msisdn+" "+"amount"+" "+amount);
        ResponseUpdate cyclePayment = new ResponseUpdate();
            try {

                TbOrigin resOrigin = null;
                resOrigin = daoOrigin.getByIdObject(Integer.parseInt(originId));
                if(resOrigin!=null) {
                    cyclePayment = operations.getUpdateAmount(originId, msisdn, trxId, amount, resOrigin.getDescription(), resOrigin.getOtt(),resOrigin.getOperatorId());
                } else {
                    cyclePayment.setResponseCode("1");
                    cyclePayment.setDescription("Fail GetBalance&Date");                
                }          
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
              System.out.println(cyclePayment.getString());
              return cyclePayment;
    }
    
    
    @WebMethod(operationName = "credit_limit_cycle_payment_dud")
    public ResponseUpdate creditLimitCyclePaymentDud(@WebParam(name = "originId") String originId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "amount") String amount)  {
         System.out.println("Id"+" "+originId+" "+"msisdn" +msisdn+" "+"amount"+" "+amount);
        ResponseUpdate cyclePayment = new ResponseUpdate();
        try {
            
            TbOrigin resOrigin = null;
            resOrigin = daoOrigin.getByIdObject(Integer.parseInt(originId));
            if(resOrigin!=null) {
                cyclePayment = operations.getCyclePaymentDud(originId,msisdn,trxId,amount,resOrigin.getDescription(),resOrigin.getOtt(),resOrigin.getOperatorId());
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


    @WebMethod(operationName = "credit_limit_current_balance")
    public ResponseCurrentBalance credit_limit_current_balance(@WebParam(name = "originId") String originId, @WebParam(name = "msisdn") String msisdn, @WebParam(name = "trxId") String trxId) {
    System.out.println("Id"+" "+originId+" "+"msisdn" +msisdn);
        
    ResponseCurrentBalance response = new ResponseCurrentBalance();
    TbOrigin resOrigin = null;
    resOrigin = daoOrigin.getByIdObject(Integer.parseInt(originId));
    if(resOrigin!=null) {
        try {
            response = operations.getCurrentBalance(originId,msisdn,trxId,resOrigin.getDescription(),resOrigin.getOtt(),resOrigin.getOperatorId());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
            } else {
                response.setResponseCode("1");
                response.setDescription("Fail GetBalance&Date");                
            } 
    System.out.println(response.getString());
    return response;
    }
    
    
    @WebMethod(operationName = "credit_limit_cycle_payment")
    public ResponseUpdate creditLimitCyclePayment(@WebParam(name = "originId") String originId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "amount") String amount)  {
        ResponseUpdate cyclePayment = new ResponseUpdate();
        try {
            
            TbOrigin resOrigin = null;
            resOrigin = daoOrigin.getByIdObject(Integer.parseInt(originId));
            if(resOrigin!=null) {
                cyclePayment = operations.getCyclePayment(originId,msisdn,trxId,amount,resOrigin.getDescription(),resOrigin.getOtt(),resOrigin.getOperatorId());
            } else {
                cyclePayment.setResponseCode("1");
                cyclePayment.setDescription("Fail GetBalance&Date");                
            }          
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WsCsPosPaidOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
          return cyclePayment;
    }
    
}
