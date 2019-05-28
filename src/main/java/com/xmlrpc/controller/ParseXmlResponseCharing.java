
package com.xmlrpc.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder; 
import com.xmlrpc.pojo.MemberChild;
import com.xmlrpc.pojo.ResponseCharing;
import com.xmlrpc.pojo.ObjectCharingResponse;


/**
 *
 * @author Edgar Giovanni Hurtarte
 */
public class ParseXmlResponseCharing implements ProcessXml {

    
    @Override
    public ResponseCharing getParseXmlToObject(String xmlString) {
        ResponseCharing responseCharing = new ResponseCharing();
        ArrayList<MemberChild> objectList = new ArrayList();
        try {

            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new StringReader(xmlString));

            responseCharing.setNameResponse(document.getRootElement().getName());
            Element classElement = document.getRootElement();

            List<Element> studentList = classElement.getChildren();
            //System.out.println("----------------------------");

            Element student = studentList.get(0);

            List<Element> studentMembersRoot = student.getChild("param").
                    getChild("value").
                    getChild("struct").getChildren();

            for (int temp3 = 0; temp3 < studentMembersRoot.size(); temp3++) {

                HashMap member = new HashMap();
                MemberChild objectMember = new MemberChild();
                Element student3 = studentMembersRoot.get(temp3);

                objectMember.setName(student3.getChild("name").getValue());
                String name = student3.getChild("value").getChildren().get(0).getName();

                if (name.contains("struct")) {
                    List<Element> studentMembers = student3.getChild("value").getChild("struct").getChildren();
                    for (int temp2 = 0; temp2 < studentMembers.size(); temp2++) {
                        Element student2 = studentMembers.get(temp2);

                        member.put(student2.getChild("name").getValue().trim(), student2.getChild("value").getValue().trim());
                    }
                    objectMember.setChild(member);
                }

                if (name.contains("string") || name.contains("dateTime.iso8601") || name.contains("i4")) {
                    List<Element> studentMembers = student3.getChild("value").getChildren();
                    for (int temp2 = 0; temp2 < studentMembers.size(); temp2++) {
                        Element student2 = studentMembers.get(temp2);

                        member.put(temp2, student2.getValue().trim());
                    }
                    objectMember.setChild(member);
                }

                if (name.contains("array")) {

                    String valStruct = "";
                    List<Element> studentMembers = student3.getChild("value").getChild("array").getChild("data").getChildren();

                    for (int temp2 = 0; temp2 < studentMembers.size(); temp2++) {

                        Element student2 = studentMembers.get(temp2);
                        List<Element> studentSubMembers = student2.getChildren();

                        if (studentSubMembers.size() > 0) {
                            valStruct = studentSubMembers.get(0).getName();
                        }

                        if (valStruct.contains("struct")) {
                            List<Element> studentStructMembers = student2.getChild("struct").getChildren();
                            HashMap child = new HashMap();
                            for (int index = 0; index < studentStructMembers.size(); index++) {

                                Element structSub = studentStructMembers.get(index);
                                child.put(structSub.getChild("name").getValue().trim(), structSub.getChild("value").getValue().trim());
                            }
                            member.put(temp2, child);

                        } else {
                            member.put(temp2, student2.getValue().trim());

                        }
                    }
                    objectMember.setChild(member);
                }

                objectList.add(objectMember);
            }

        } catch (JDOMException ex) {
            Logger.getLogger(ParseXmlResponseCharing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParseXmlResponseCharing.class.getName()).log(Level.SEVERE, null, ex);
        }
        responseCharing.setMembers(objectList);

        return responseCharing;
    }


    @Override
    public ObjectCharingResponse getInformationMember(ResponseCharing response,String parameter) {
    
    ObjectCharingResponse resultValueDedicatedAccountInformation = new ObjectCharingResponse();
    HashMap object= new HashMap();
    HashMap memberDedicatedAccountInformation = null;
    
    for(int tree1=0;tree1<response.getMembers().size();tree1++){        
            if(response.getMembers().get(tree1).getName().contains(parameter)){
                int size = response.getMembers().get(tree1).getChild().size();
                
                for (int tree2=0;tree2<response.getMembers().get(tree1).getChild().size();tree2++){   
                    if(size>=3){
                    memberDedicatedAccountInformation= (HashMap) response.getMembers().get(tree1).getChild().get(tree2);
                    }
                    
                    if(memberDedicatedAccountInformation==null){                        
                        memberDedicatedAccountInformation=(HashMap) response.getMembers().get(tree1).getChild();
                        object.put(tree2, memberDedicatedAccountInformation);
                        resultValueDedicatedAccountInformation.setMemberValue(object);
                        //resultValueDedicatedAccountInformation.setSumDedicatedValue1(sumVal);
                        resultValueDedicatedAccountInformation.setNameMemberArray(parameter);
                        return resultValueDedicatedAccountInformation;
                    }
                
                    object.put(tree2, memberDedicatedAccountInformation);
                 
                }
        
                resultValueDedicatedAccountInformation.setMemberValue(object);
                //resultValueDedicatedAccountInformation.setSumDedicatedValue1(sumVal);
                resultValueDedicatedAccountInformation.setNameMemberArray(parameter);
          
            }
    
    }    

    
    
        
        
       return resultValueDedicatedAccountInformation;
    }


    
    
}
