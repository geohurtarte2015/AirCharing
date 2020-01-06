package com.pojo;
// Generated 30/10/2018 12:51:06 PM by Hibernate Tools 4.3.1



public class TbOrigin  implements java.io.Serializable {



     private long idOrigin;
     private String description;
     private String ott;
     private long state;
     private long methodList;
     private long operatorId;

    public TbOrigin() {
        
    }

    public TbOrigin(long idOrigin, String description, String ott, long state, long methodList, long operatorId) {
       this.idOrigin = idOrigin;
       this.description = description;
       this.ott = ott;
       this.state = state;
       this.methodList = methodList;   
       this.operatorId = operatorId;
    }
   

    public long getIdOrigin() {
        return this.idOrigin;
    }
    
    public void setIdOrigin(long idOrigin) {
        this.idOrigin = idOrigin;
    }

    

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    

    public String getOtt() {
        return this.ott;
    }
    
    public void setOtt(String ott) {
        this.ott = ott;
    }

    

    public long getState() {
        return this.state;
    }
    
    public void setState(long state) {
        this.state = state;
    }

    

    public long getMethodList() {
        return this.methodList;
    }
    
    public void setMethodList(long methodList) {
        this.methodList = methodList;
    }
    

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }




}


