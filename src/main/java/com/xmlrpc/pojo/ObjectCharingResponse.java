
package com.xmlrpc.pojo;


import java.util.HashMap;

/**
 *
 * @author Edgar Giovanni Hurtarte
 */
public class ObjectCharingResponse {
    
     private HashMap memberValue;
    private String nameMemberArray;

 
    public HashMap getMemberValue() {
        return memberValue;
    }

   
    public void setMemberValue(HashMap memberValue) {
        this.memberValue = memberValue;
    }
    
   
  
    public String getNameMemberArray() {
        return nameMemberArray;
    }

  
    public void setNameMemberArray(String nameMemberArray) {
        this.nameMemberArray = nameMemberArray;
    }
    
      
      public String toString(){//overriding the toString() method  
        return " "+ getMemberValue();
    }  

   
    
}
