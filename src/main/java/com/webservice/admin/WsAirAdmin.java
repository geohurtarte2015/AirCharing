/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.admin;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author LENOVO
 */
@WebService(serviceName = "WsAirAdmin")
public class WsAirAdmin {

      @WebMethod(operationName = "put")
    public String putCatalog(@WebParam(name = "origenId") String origenId,@WebParam(name = "description") String description,@WebParam(name = "ott") String ott,@WebParam(name = "method") String method,@WebParam(name = "state") String state) {
        return "Hello " + description + " !";
    }
    
    @WebMethod(operationName = "update")
    public String updateCatalog(@WebParam(name = "origenId") String origenId,@WebParam(name = "description") String description,@WebParam(name = "ott") String ott,@WebParam(name = "method") String method,@WebParam(name = "state") String state) {
        return "Hello " + description + " !";
    }
    
    @WebMethod(operationName = "updateState")
    public String updateCatalogState(@WebParam(name = "origenId") String origenId,@WebParam(name = "state") String state) {
        return "Hello " + state + " !";
    }
    
    
}
