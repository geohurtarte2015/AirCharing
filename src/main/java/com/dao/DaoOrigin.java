/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import configurationHibernate.HibernateUtil;
import com.pojo.TbOrigin;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;



public class DaoOrigin{
    
    private Session sesion;
    
    public DaoOrigin(){
     
        sesion = HibernateUtil.getSessionFactory().openSession();
    
    }
    



  public List<TbOrigin> listAll(){   
          sesion.beginTransaction();
          List<TbOrigin> origin= sesion.createQuery("from TbOrigin").setCacheable(true).list(); 
          sesion.getTransaction().commit();            
       return origin;
   } 



 public TbOrigin getByIdObject(long idOrigin){
       List<TbOrigin> origin = null;
       TbOrigin objectOrigin = null;
       try{                            
        
           origin= sesion.createQuery("from TbOrigin origin where origin.idOrigin="+idOrigin+"").setCacheable(true).list();
                    
           if(origin==null || origin.isEmpty()){     
             return objectOrigin=null;
           }else{
           objectOrigin=origin.get(0);
           }
            
       }catch(HibernateException he){  
        System.out.println("Error result query");
        
       
       } finally {           
                 
       }
       
       
       return objectOrigin;
   }

    
}
