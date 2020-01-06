
package com.webservice.main_ope;

import com.controller.Operations;

import com.pojo.ResponseUpdate;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



@WebService(serviceName = "WsCsPosMainOperations")
public class WsCsPosMainOperations {
    
    private static Operations operations=null;
    private static String responseText="";
    
    
    public WsCsPosMainOperations(){
        if (operations == null) {
            operations = new Operations();
        }

    }

    @WebMethod(operationName = "update_limit")
    public ResponseUpdate updateLimit(@WebParam(name = "originId") String originId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "amount") String amount, @WebParam(name = "ott") String ott) throws ParserConfigurationException, SAXException {
        ResponseUpdate responseUpdateAmount = new ResponseUpdate();
        //TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(originId));
        responseUpdateAmount = operations.getUpdateAmountLimit("CLARO",msisdn, trxId,amount,ott);  
        return responseUpdateAmount;
    }
    
}
