
package com.controller;

import com.dao.DaoOrigin;
import com.pojo.ResponseCurrentBalance;
import com.pojo.TbOrigin;
import java.util.List;


public class Main {
   
    public static void main(String[] args) {
    
//      DaoOrigin daoOrigin = new DaoOrigin();
//      List<TbOrigin> origins =  daoOrigin.listAll(); 
//      System.out.println(origins.get(0).getDescription());
    
    ResponseCurrentBalance responseCurrent = new ResponseCurrentBalance();
    responseCurrent.setResponseCode("1");
    responseCurrent.setDescription("Succesful");
    responseCurrent.setUsageBalance("55000");
    responseCurrent.setCurrentBalance("45646");
    
    System.out.println("Respuesta"+responseCurrent);
    

        
    
    }
    
}
