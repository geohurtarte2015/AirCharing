
package com.xmlrpc.pojo;

import java.util.ArrayList;



public class ResponseCharing {
    
    
    private ArrayList<MemberChild> members; 
    private String nameResponse;
   

    
    public ArrayList<MemberChild> getMembers() {
        return members;
    }

    
    public void setMembers(ArrayList<MemberChild> members) {
        this.members = members;
    }

    
    public String getNameResponse() {
        return nameResponse;
    }

    
    public void setNameResponse(String nameResponse) {
        this.nameResponse = nameResponse;
    }
    
      public String toString(){//overriding the toString() method  
        return "Response: "+nameResponse+" \n"+members+"\n";
    }  

  
    
    
}
