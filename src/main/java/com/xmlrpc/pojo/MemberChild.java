
package com.xmlrpc.pojo;

import java.util.HashMap;

/**
 *
 * @author Edgar Giovanni Hurtarte Claro 2018
 */
public class MemberChild {
    
    private String name;
    private HashMap child;
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the child
     */
    public HashMap getChild() {
        return child;
    }

    /**
     * @param child the child to set
     */
    public void setChild(HashMap child) {
        this.child = child;
    }
    
     public String toString(){//overriding the toString() method  
        return "Name: "+name+" \n"+child+"\n";
    }  
    
 
}
