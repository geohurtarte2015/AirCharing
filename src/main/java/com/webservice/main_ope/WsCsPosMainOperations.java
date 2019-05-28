
package com.webservice.main_ope;

import com.controller.Operations;
import com.dao.DaoOrigin;
import com.pojo.CyclePayment;
import com.pojo.ResponseUpdate;
import com.pojo.TbOrigin;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



@WebService(serviceName = "WsCsPosMainOperations")
public class WsCsPosMainOperations {
    
    private static Operations operations=null;
    private static String responseText="";
    private  DaoOrigin daoOrigin=null;

    
    
    public WsCsPosMainOperations(){
        if (operations == null) {
            operations = new Operations();
        }
        daoOrigin = new DaoOrigin();
        List<TbOrigin> origins = daoOrigin.listAll();
        daoOrigin = new DaoOrigin();
    }

    @WebMethod(operationName = "update_limit")
    public ResponseUpdate updateLimit(@WebParam(name = "originId") String originId,@WebParam(name = "msisdn") String msisdn,@WebParam(name = "trxId") String trxId,@WebParam(name = "amount") String amount) throws ParserConfigurationException, SAXException {
        ResponseUpdate responseUpdateAmount = new ResponseUpdate();
        TbOrigin resOrigin = daoOrigin.getByIdObject(Integer.parseInt(originId));
        responseUpdateAmount = operations.getUpdateAmountLimit(resOrigin.getDescription(),msisdn, trxId,amount,resOrigin.getOtt());  
        return responseUpdateAmount;
    }
    
}
