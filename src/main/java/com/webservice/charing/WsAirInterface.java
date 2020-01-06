
package com.webservice.charing;
import com.controller.Operations;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.pojo.GetBalance;
import com.pojo.ResponseBalance;
import com.pojo.ResponseCurrentBalance;




@WebService(serviceName = "WsAirInterface")
public class WsAirInterface {
    private static Operations operations=null;
    private static String responseText="";

    
   public WsAirInterface() {
     if (operations == null) {
           operations = new Operations();     
       }      
   }

    @WebMethod(operationName = "getDataBalance")
    public GetBalance getBalance(@WebParam(name = "msisdn") String msisdn, @WebParam(name = "origenId") String origenId) {
                        
        GetBalance responseGetBalance = new GetBalance();
        try {   
            responseGetBalance = operations.getBalanceAccount(msisdn, origenId);
         
        } catch (SAXException ex) {
            Logger.getLogger(WsAirInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WsAirInterface.class.getName()).log(Level.SEVERE, null, ex);

        }
        return responseGetBalance;
    }

    @WebMethod(operationName = "getDataRefill")
    public ResponseBalance getRefill(@WebParam(name = "idTransaction") String idTransaction,@WebParam(name = "msisdn") String msisdn, @WebParam(name = "amount") String amount, @WebParam(name = "origenId") String origenId,@WebParam(name = "ott") String ott) {
       
       long startTime = System.currentTimeMillis();
       //System.out.println("Begin : "+startTime);
        ResponseBalance responseRefill = new ResponseBalance();
        
        try {
            //TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(origenId));
            
            responseRefill = operations.getRefill(idTransaction,msisdn, origenId, amount, ott);
            
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

    @WebMethod(operationName = "getValidate")
    public boolean geValidateBalance(@WebParam(name = "msisdn") String msisdn, @WebParam(name = "origenId") String origenId) {
        //operations = new Operations();
        boolean getValidate = true;
         //TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(origenId));
        try {
            getValidate = operations.getValidateRefill(msisdn, origenId,"CLARO");
        } catch (SAXException ex) {
            Logger.getLogger(WsAirInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WsAirInterface.class.getName()).log(Level.SEVERE, null, ex);

        }
        return getValidate;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsageThresholdsAndCounters")
    public ResponseCurrentBalance getUsageThresholdsAndCounters(@WebParam(name = "msisdn") String msisdn, @WebParam(name = "origin") String origin) {
          ResponseCurrentBalance responseGetBalance = new ResponseCurrentBalance();
          responseGetBalance = operations.getThresholdsAndCounters(origin,msisdn);
        return responseGetBalance;
    }


    @WebMethod(operationName = "getDataRemoveRefill")
    public String getDataRemoveRefill(@WebParam(name = "origenId") String origenId, @WebParam(name = "msisdn") String msisdn, @WebParam(name = "trx") String trx, @WebParam(name = "amount") String amount, @WebParam(name = "ott") String ott) {
        //TODO write your implementation code here:
        return null;
    }



}
