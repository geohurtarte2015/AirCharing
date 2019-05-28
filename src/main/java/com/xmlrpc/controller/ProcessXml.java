
package com.xmlrpc.controller;

import com.xmlrpc.pojo.ResponseCharing;
import com.xmlrpc.pojo.ObjectCharingResponse;

/**
 *
 * @author Edgar Giovanni Hurtarte
 */
public interface ProcessXml {
    
    public ResponseCharing getParseXmlToObject(String xmlString);
    
    public ObjectCharingResponse getInformationMember(ResponseCharing response,String parameter);
        
}
