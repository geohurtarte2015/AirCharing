
package com.webservice.charing;
import configurationHibernate.HibernateUtil;
import com.controller.Operations;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.pojo.GetBalance;
import com.pojo.Refill;
import com.dao.DaoOrigin;
import com.pojo.ResponseBalance;
import com.pojo.ResponseCurrentBalance;
import com.pojo.TbOrigin;
import configurationHibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;



@WebService(serviceName = "WsAirInterface")
public class WsAirInterface {


    private static Operations operations=null;
    private static String responseText="";
    private  DaoOrigin daoOrigin=null;
//    private static List<TbOrigin> origins=null;
    
   public WsAirInterface() {
     if (operations == null) {
           operations = new Operations();     
       }     
           daoOrigin= new DaoOrigin();
           List<TbOrigin> origins = daoOrigin.listAll();
           daoOrigin= new DaoOrigin();   
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
    public ResponseBalance getRefill(@WebParam(name = "msisdn") String msisdn, @WebParam(name = "amount") String amount, @WebParam(name = "origenId") String origenId) {
       
       long startTime = System.currentTimeMillis();
       //System.out.println("Begin : "+startTime);
        ResponseBalance responseRefill = new ResponseBalance();
        
        try {
            TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(origenId));
            responseRefill = operations.getRefill(msisdn, origenId, amount,resOrigin.getOtt());

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
         TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(origenId));
        try {
            getValidate = operations.getValidateRefill(msisdn, origenId,resOrigin.getDescription());
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



}
