package com.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.pojo.GetBalance;

import com.pojo.OfferId;
import com.pojo.Refill;
import com.pojo.ResponseBalance;
import com.pojo.ResponseCurrentBalance;
import com.pojo.ResponseGetAccountDetails;
import com.pojo.ResponseUpdate;
import com.pojo.ResponseValue;
import com.xmlrpc.pojo.ObjectCharingResponse;
import com.xmlrpc.controller.ParseXmlResponseCharing;
import com.xmlrpc.pojo.ResponseCharing;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Operations extends XmlRequest {
    
private static final PoolHttp poolHttp = new PoolHttp();
private static final ParseXmlResponseCharing parse = new ParseXmlResponseCharing();
private static final String date ="20180613T18:35:20+0500";
private static final String currency="GTQ";
private ResponseCodeCharing responseCodeCharing = new ResponseCodeCharing();
private  HashMap  responseErrorCode = new HashMap();


public Operations(){    
 
}

public ResponseGetAccountDetails getAccountDetailServiceClassCurrent(String msisdn,String nameOrigen) throws SAXException, ParserConfigurationException{
//Connection connection = new Connection();

ResponseGetAccountDetails response = new ResponseGetAccountDetails();


//String xmlResponse = connection.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence, originHostName));
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetAccountDetail(msisdn, date, sequence(msisdn), nameOrigen));


ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse objectCharingServiceClassCurrent = parse.getInformationMember(responseGetBalance, "serviceClassCurrent");

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");

    if(xmlResponse.contains("Error response")){
        response = new ResponseGetAccountDetails(); 
        response.setDescription("Error connection");
        response.setResponseCode("1000");
        response.setResponseValue("-1"); 
        return response;
    }

String valResponseCode = ((String)((HashMap) responseCode.getMemberValue().get(0)).get(0));


String valResponseValue = ((String)((HashMap) objectCharingServiceClassCurrent.getMemberValue().get(0)).get(0));


if (Integer.parseInt(valResponseCode)>9){
 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 
 response = new ResponseGetAccountDetails(); 
 response.setResponseCode(valResponseCode);
 response.setDescription(nameError);
 response.setResponseValue("-1"); 
 return response;
}

 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 

response.setDescription(nameError);
response.setResponseCode(valResponseCode);
response.setResponseValue(valResponseValue);


return response;
    
    }

public ResponseGetAccountDetails getOfferDetails(String msisdn,String nameOrigen, String offerId) throws SAXException, ParserConfigurationException{
//Connection connection = new Connection();

ResponseGetAccountDetails response = new ResponseGetAccountDetails();

//String xmlResponse = connection.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence, originHostName));
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetAccountDetail(msisdn, date, sequence(msisdn), nameOrigen));


ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse objectCharingServiceClassCurrent = parse.getInformationMember(responseGetBalance, "offerInformationList");

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");

    if(xmlResponse.contains("Error response")){
        response = new ResponseGetAccountDetails(); 
        response.setDescription("Error connection");
        response.setResponseCode("1000");
        response.setResponseValue("-1"); 
        return response;
    }

String valResponseCode = ((String)((HashMap) responseCode.getMemberValue().get(0)).get(0));


String valResponseValue = ((String)((HashMap) objectCharingServiceClassCurrent.getMemberValue().get(0)).get(0));


if (Integer.parseInt(valResponseCode)>9){
 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 
 response = new ResponseGetAccountDetails(); 
 response.setResponseCode(valResponseCode);
 response.setDescription(nameError);
 response.setResponseValue("-1"); 
 return response;
}



int sizeCharingInformationList = objectCharingServiceClassCurrent.getMemberValue().size();
ResponseValue responseValueObject = null;


for (int index=0;index<sizeCharingInformationList;index++){        
    HashMap value =   (HashMap) objectCharingServiceClassCurrent.getMemberValue().get(index);    
    int valOfferId = Integer.parseInt((String) value.get("offerID"));
    if (valOfferId==Integer.parseInt(offerId)){
        responseValueObject = new ResponseValue();
        responseValueObject.setOfferType((String) value.get("offerType"));
        responseValueObject.setOfferState((String) value.get("offerState"));
        responseValueObject.setStartDate((String) value.get("startDateTime"));
        responseValueObject.setExpiryDateTime((String) value.get("expiryDateTime"));
    }
}






 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 

response.setDescription(nameError);
response.setResponseCode(valResponseCode);
response.setResponseValue(valResponseValue);


return response;
    
    }

public ResponseGetAccountDetails getActivationDate(String msisdn,String nameOrigen) throws SAXException, ParserConfigurationException{
//Connection connection = new Connection();

ResponseGetAccountDetails response = new ResponseGetAccountDetails();


//String xmlResponse = connection.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence, originHostName));
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetAccountDetail(msisdn, date, sequence(msisdn), nameOrigen));

if(xmlResponse.contains("Error response")){
response = new ResponseGetAccountDetails(); 
 response.setDescription("Error connection");
 response.setResponseCode("1000");
 response.setResponseValue("-1"); 
 return response;
}

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse objectCharingServiceClassCurrent = parse.getInformationMember(responseGetBalance, "activationDate");

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");


int sizeObjectCharingServiceClassCurrent = objectCharingServiceClassCurrent.getMemberValue().size();

String valResponseCode = ((String)((HashMap) responseCode.getMemberValue().get(0)).get(0));

String valResponseValue = ((String)((HashMap) objectCharingServiceClassCurrent.getMemberValue().get(0)).get(0));

if (Integer.parseInt(valResponseCode)>9){
 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 
 response = new ResponseGetAccountDetails(); 
 response.setDescription(nameError);
 response.setResponseCode(valResponseCode);
 response.setResponseValue("-1"); 
 return response;
}

String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 
response.setDescription(nameError);
response.setResponseCode(valResponseCode);
response.setResponseValue(valResponseValue);


return response;
    
    }

public GetBalance getBalanceAccount(String msisdn,String nameOrigen) throws SAXException, ParserConfigurationException{
//Connection connection = new Connection();

GetBalance getBalance = new GetBalance();
//ParseXmlResponseCharing parse = new ParseXmlResponseCharing();
//Connection connection = new Connection();


String date ="20180613T18:35:20+0500";
String originHostName = nameOrigen;
HashMap accountInformation = new HashMap();
HashMap informationList = new HashMap();
int[] id = {1001,1002,1003,1004,1005};


accountInformation.put(id[0],-1);
accountInformation.put(id[1],-1);
accountInformation.put(id[2],-1);
accountInformation.put(id[3],-1);

informationList.put(id[0],"");
informationList.put(id[1],"");
informationList.put(id[2],"");
informationList.put(id[3],"");



int[] valueSumId = {0,0,0,0,0};

//PANAMA
//String xmlResponse = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originHostName));

//GUATEMALA
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originHostName));


ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse objectCharingAccountInformation = parse.getInformationMember(responseGetBalance, "dedicatedAccountInformation");
ObjectCharingResponse objectCharingInformationList = parse.getInformationMember(responseGetBalance, "offerInformationList");
ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
String valResponseCode = (String) valHashMapResponseCode.get(0);

if (Integer.parseInt(valResponseCode)>9){

 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));    
 getBalance.setResponseCode(valResponseCode);
 getBalance.setDescription(nameError);
 return getBalance;
}


int sizeCharingInformationList = objectCharingInformationList.getMemberValue().size();
int sizeObjectCharingAccountInformation = objectCharingAccountInformation.getMemberValue().size();


for (int index=0;index<sizeCharingInformationList;index++){
        
    HashMap value =    (HashMap) objectCharingInformationList.getMemberValue().get(index);    
    int valId = Integer.parseInt((String) value.get("offerID"));
    switch(valId){
        case 50001:             
             informationList.put(1001,value.get("expiryDateTime"));
             break;
        case 50002:
             informationList.put(1002,value.get("expiryDateTime"));
             break;
        case 50003:
             informationList.put(1003,value.get("expiryDateTime"));
             break;
        case 50004:
             informationList.put(1004,value.get("expiryDateTime"));
             break;
    }
    
}


for (int index=0;index<sizeObjectCharingAccountInformation;index++){
  
    HashMap value =    (HashMap) objectCharingAccountInformation.getMemberValue().get(index);
    int valId = Integer.parseInt((String) value.get("dedicatedAccountID"));
    switch(valId){
        case 1001:         
             valueSumId[0]=valueSumId[0]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1001,valueSumId[0]);                
             break;
        case 1002:
              valueSumId[1]=valueSumId[1]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1002,valueSumId[1]);  
             break;
        case 1003:
              valueSumId[2]=valueSumId[2]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1003,valueSumId[2]);  
             break;
        case 1004:
             valueSumId[3]=valueSumId[3]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1004,valueSumId[3]);  
             break;
    }
    
}

ArrayList<OfferId> listOfferId = new ArrayList<>();
    for (int index = 0; index < accountInformation.size(); index++) {
        if (((int)  accountInformation.get(id[index])) != -1) {
            OfferId offerId = new OfferId(String.valueOf(id[index]), (int) accountInformation.get(id[index]), (String) informationList.get(id[index]));
            listOfferId.add(offerId);
        }
    }


getBalance.setOfferId(listOfferId);


return getBalance;
    
    }

public GetBalance getIndividualAccount(String msisdn,String origenId,String originName) throws SAXException, ParserConfigurationException{
//Connection connection = new Connection();

GetBalance getBalance = new GetBalance();
//ParseXmlResponseCharing parse = new ParseXmlResponseCharing();
//Connection connection = new Connection();

String date ="20180613T18:35:20+0500";


HashMap accountInformation = new HashMap();
HashMap informationList = new HashMap();
int[] id = {1001,1002,1003,1004,1005};


accountInformation.put(id[0],-1);
accountInformation.put(id[1],-1);
accountInformation.put(id[2],-1);
accountInformation.put(id[3],-1);

informationList.put(id[0],"");
informationList.put(id[1],"");
informationList.put(id[2],"");
informationList.put(id[3],"");



int[] valueSumId = {0,0,0,0,0};

//Panama
//String xmlResponse = connection.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence, originHostName));

//Guatemala
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originName));


ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse objectCharingAccountInformation = parse.getInformationMember(responseGetBalance, "dedicatedAccountInformation");
ObjectCharingResponse objectCharingInformationList = parse.getInformationMember(responseGetBalance, "offerInformationList");


int sizeCharingInformationList = objectCharingInformationList.getMemberValue().size();
int sizeObjectCharingAccountInformation = objectCharingAccountInformation.getMemberValue().size();


for (int index=0;index<sizeCharingInformationList;index++){
        
    HashMap value =    (HashMap) objectCharingInformationList.getMemberValue().get(index);    
    int valId = Integer.parseInt((String) value.get("offerID"));
    switch(valId){
        case 50001:             
             informationList.put(1001,value.get("expiryDateTime"));
             break;
        case 50002:
             informationList.put(1002,value.get("expiryDateTime"));
             break;
        case 50003:
             informationList.put(1003,value.get("expiryDateTime"));
             break;
        case 50004:
             informationList.put(1004,value.get("expiryDateTime"));
             break;
    }
    
}


for (int index=0;index<sizeObjectCharingAccountInformation;index++){
  
    HashMap value =    (HashMap) objectCharingAccountInformation.getMemberValue().get(index);
    int valId = Integer.parseInt((String) value.get("dedicatedAccountID"));
    switch(valId){
        case 1001:         
             valueSumId[0]=valueSumId[0]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1001,valueSumId[0]);                
             break;
        case 1002:
              valueSumId[1]=valueSumId[1]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1002,valueSumId[1]);  
             break;
        case 1003:
              valueSumId[2]=valueSumId[2]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1003,valueSumId[2]);  
             break;
        case 1004:
             valueSumId[3]=valueSumId[3]+(Integer.parseInt((String) value.get("dedicatedAccountActiveValue1")));             
             accountInformation.put(1004,valueSumId[3]);  
             break;
    }
    
}

ArrayList<OfferId> listOfferId = new ArrayList<>();
    for (int index = 0; index < accountInformation.size(); index++) {
        if (((int)  accountInformation.get(id[index])) != -1) {
            OfferId offerId = new OfferId(String.valueOf(id[index]), (int) accountInformation.get(id[index]), (String) informationList.get(id[index]));
            listOfferId.add(offerId);
        }
    }


getBalance.setOfferId(listOfferId);


return getBalance;
    
    }

public ResponseBalance getRefill(String msisdn,String amount, String nameOrigin,String ott) throws ParserConfigurationException, SAXException{

ResponseBalance response = null;
//String xmlNormal = connection.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",stringGetBalance);
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestRefill(msisdn, date, sequence(msisdn), nameOrigin, amount, currency, ott));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse originTransaction = parse.getInformationMember(responseGetBalance, "originTransactionID");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
String valResponseCode = (String) valHashMapResponseCode.get(0);

HashMap valHashMapOriginTransaction = (HashMap) originTransaction.getMemberValue().get(0);
String valOriginTransaction = (String) valHashMapOriginTransaction.get(0);

if (Integer.parseInt(valResponseCode)>0){

 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 
 response = new ResponseBalance(); 
 response.setDescription(nameError);
 response.setResponseCode(valResponseCode);
 return response;
}

String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));
response = new ResponseBalance(valResponseCode,nameError);

    
return response;
    }

public boolean getValidateRefill(String msisdn,String origenId,String originName) throws ParserConfigurationException, SAXException{
boolean validate = true;
String date ="20180613T18:35:20+0500";

String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originName));
ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);
ObjectCharingResponse objectCharingInformationList = parse.getInformationMember(responseGetBalance, "offerInformationList");

if(objectCharingInformationList.getNameMemberArray()!=null){
int sizeCharingInformationList = objectCharingInformationList.getMemberValue().size();
for (int index=0;index<sizeCharingInformationList;index++){
        
    HashMap value =    (HashMap) objectCharingInformationList.getMemberValue().get(index);    
    int valId = Integer.parseInt((String) value.get("offerID"));
    switch(valId){
        case 50120:             
             validate=false;
             break;      
    }
    
}
}else{
return false;
}

 
 return validate;
}

public Refill getUpdateRefill(String msisdn,String origenId,String amount, String originHostName,String ott) throws ParserConfigurationException, SAXException{

//String xmlNormal = connection.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",stringGetBalance);
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestRefill(msisdn, date, sequence(msisdn), originHostName, amount, currency, ott));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse originTransaction = parse.getInformationMember(responseGetBalance, "originTransactionID");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
String valResponseCode = (String) valHashMapResponseCode.get(0);

HashMap valHashMapOriginTransaction = (HashMap) originTransaction.getMemberValue().get(0);
String valOriginTransaction = (String) valHashMapOriginTransaction.get(0);


Refill refill = new Refill(valOriginTransaction,valResponseCode);        
    
return refill;
    }

public Refill getUpdateOffer(String msisdn,String origenId,String amount,String originHostName,String ott) throws ParserConfigurationException, SAXException{

//String xmlNormal = connection.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",stringGetBalance);
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestRefill(msisdn, date, sequence(msisdn), originHostName, amount, currency, ott));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse originTransaction = parse.getInformationMember(responseGetBalance, "originTransactionID");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
String valResponseCode = (String) valHashMapResponseCode.get(0);

HashMap valHashMapOriginTransaction = (HashMap) originTransaction.getMemberValue().get(0);
String valOriginTransaction = (String) valHashMapOriginTransaction.get(0);


Refill refill = new Refill(valOriginTransaction,valResponseCode);        
    
return refill;
    }

//credit_limit_update_amount modificando
public ResponseUpdate getUpdateAmount(String originId,String msisdn,String trxId,String amount,String originHostName, String ott,long operatorId) throws ParserConfigurationException, SAXException{
 String valResponseCode="1";
String valResponseCodeUpdate="1";
String valResponseCodeCounter="1";
String offerID="0";

HashMap informationList = new HashMap();
ResponseUpdate updateAmount= new ResponseUpdate();
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originHostName));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse offerInformationList = parse.getInformationMember(responseGetBalance, "offerInformationList");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
valResponseCode = (String) valHashMapResponseCode.get(0);

System.out.println("Response code offerInformationList"+valResponseCode);

if (Integer.parseInt(valResponseCode)>9){
valResponseCode="1";
 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));    
 updateAmount.setResponseCode(valResponseCode);
 updateAmount.setDescription(nameError);
 return updateAmount;
}


int sizeObjectCharingOfferInofrmationList = offerInformationList.getMemberValue().size();

for (int index=0;index<sizeObjectCharingOfferInofrmationList;index++){
        
    HashMap value =    (HashMap) offerInformationList.getMemberValue().get(index);    
    int valId = Integer.parseInt((String) value.get("offerID"));
    switch(valId){
        case 50050:            
             offerID = String.valueOf(valId);            
             break;   
        case 50001:            
             offerID = String.valueOf(valId);            
             break;  
    }
    
}

//System.out.println("Last Amount: "+accountValue);




if (Integer.parseInt(valResponseCode)>9){
valResponseCode="1";
}else{
String xmlUpdateResponse = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlUpdateOffer(msisdn, date, this.sequence(msisdn), originHostName, amount, currency,offerID));
ResponseCharing responseGetBalanceUpdate = parse.getParseXmlToObject(xmlUpdateResponse);
ObjectCharingResponse responseCodeUpdate = parse.getInformationMember(responseGetBalanceUpdate, "responseCode");
HashMap valHashMapResponseCodeUpdate =   (HashMap) responseCodeUpdate.getMemberValue().get(0);
valResponseCodeUpdate = (String) valHashMapResponseCodeUpdate.get(0);
System.out.println("Response code UpdateOffer"+valResponseCodeUpdate);
if (Integer.parseInt(valResponseCodeUpdate)>9){
valResponseCode="4";
}else{    
//String xmlThresholdsCounter = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlUsageThresholdsAndCounters(msisdn, date, this.sequence(msisdn), originId, amount, currency, operatorId));
String xmlThresholdsCounter = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRunPeriodicAccountManagement(msisdn, date, this.sequence(msisdn), originHostName, amount, currency, operatorId));
ResponseCharing responseThresholdsCounter = parse.getParseXmlToObject(xmlThresholdsCounter);
ObjectCharingResponse responseCodeCounter = parse.getInformationMember(responseThresholdsCounter, "responseCode");
HashMap valHashMapResponseCodeCounter =   (HashMap) responseCodeCounter.getMemberValue().get(0);
valResponseCodeCounter = (String) valHashMapResponseCodeCounter.get(0);
if (Integer.parseInt(valResponseCodeCounter)>9)
valResponseCode="5";
}
}

String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));
updateAmount.setResponseCode(valResponseCode);
updateAmount.setDescription(nameError);
return updateAmount;
}

//credit_limit_cycle_payment
public ResponseUpdate getCyclePayment(String originId,String msisdn,String trxId,String amount,String originHostName,String ott,long operatorId) throws ParserConfigurationException, SAXException{
String valResponseCode="1";
String valResponseCodeUpdate="1";
String valResponseCodeCounter="1";
String accountValue="0";

HashMap informationList = new HashMap();
ResponseUpdate cyclePayment= new ResponseUpdate();
String xmlResponse = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originHostName));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse dedicatedAccountInformation = parse.getInformationMember(responseGetBalance, "dedicatedAccountInformation");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
valResponseCode = (String) valHashMapResponseCode.get(0);

if (Integer.parseInt(valResponseCode)>9){
valResponseCode="1";
 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));    
 cyclePayment.setResponseCode(valResponseCode);
 cyclePayment.setDescription(nameError);
 return cyclePayment;
}


int sizeObjectCharingAccountInformation = dedicatedAccountInformation.getMemberValue().size();

for (int index=0;index<sizeObjectCharingAccountInformation;index++){
        
    HashMap value =    (HashMap) dedicatedAccountInformation.getMemberValue().get(index);    
    int valId = Integer.parseInt((String) value.get("dedicatedAccountID"));
    switch(valId){
        case 50120:            
             accountValue = (String) value.get("dedicatedAccountActiveValue1");             
             break;   
    }
    
}


System.out.println("Last amount: "+accountValue);


if (Integer.parseInt(valResponseCode)>9){
valResponseCode="1";
}else{
int valAmount = Integer.parseInt(amount);
int valAccountValue = Integer.parseInt(accountValue);
valAmount=valAmount+valAccountValue;
amount=String.valueOf(valAmount);

String xmlUpdateResponse = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestUpdateRefill(msisdn, date, this.sequence(msisdn), originHostName, amount, currency));
ResponseCharing responseGetBalanceUpdate = parse.getParseXmlToObject(xmlUpdateResponse);
ObjectCharingResponse responseCodeUpdate = parse.getInformationMember(responseGetBalanceUpdate, "responseCode");
HashMap valHashMapResponseCodeUpdate =   (HashMap) responseCodeUpdate.getMemberValue().get(0);
valResponseCodeUpdate = (String) valHashMapResponseCodeUpdate.get(0);
}

System.out.println("New amount: "+amount);



String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));
cyclePayment.setResponseCode(valResponseCode);
cyclePayment.setDescription(nameError);
 return cyclePayment;
}

//credit_limit_cycle_payment_dud
public ResponseUpdate getCyclePaymentDud(String originId,String msisdn,String trxId,String amount,String originHostName,String ott,long operatorId) throws ParserConfigurationException, SAXException{
String valResponseCode="1";
String valResponseCodeUpdate="1";
String valResponseCodeCounter="1";
String accountValue="1";

HashMap informationList = new HashMap();
ResponseUpdate cyclePayment= new ResponseUpdate();
String xmlResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originHostName));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse dedicatedAccountInformation = parse.getInformationMember(responseGetBalance, "dedicatedAccountInformation");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
valResponseCode = (String) valHashMapResponseCode.get(0);

if (Integer.parseInt(valResponseCode)>9){
valResponseCode="1";
 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));    
 cyclePayment.setResponseCode(valResponseCode);
 cyclePayment.setDescription(nameError);
 return cyclePayment;
}


int sizeObjectCharingAccountInformation = dedicatedAccountInformation.getMemberValue().size();

for (int index=0;index<sizeObjectCharingAccountInformation;index++){
        
    HashMap value =    (HashMap) dedicatedAccountInformation.getMemberValue().get(index);    
    int valId = Integer.parseInt((String) value.get("dedicatedAccountID"));
    switch(valId){
        case 50120:            
             accountValue = (String) value.get("dedicatedAccountActiveValue1");             
             break;   
    }
    
}

if(!(Integer.parseInt(accountValue)==0)){
    valResponseCode="2";
    String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));    
    cyclePayment.setResponseCode(valResponseCode);
    cyclePayment.setDescription(nameError);
    return cyclePayment;
}



if (Integer.parseInt(valResponseCode)>9){
valResponseCode="1";
}else{
String xmlUpdateResponse = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestUpdateRefill(msisdn, date, this.sequence(msisdn), originHostName, amount, currency));
ResponseCharing responseGetBalanceUpdate = parse.getParseXmlToObject(xmlUpdateResponse);
ObjectCharingResponse responseCodeUpdate = parse.getInformationMember(responseGetBalanceUpdate, "responseCode");
HashMap valHashMapResponseCodeUpdate =   (HashMap) responseCodeUpdate.getMemberValue().get(0);
valResponseCodeUpdate = (String) valHashMapResponseCodeUpdate.get(0);
if (Integer.parseInt(valResponseCodeUpdate)>9){
valResponseCode="4";
}else{    
//String xmlThresholdsCounter = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlUsageThresholdsAndCounters(msisdn, date, this.sequence(msisdn), originId, amount, currency, operatorId));
String xmlThresholdsCounter = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlUsageThresholdsAndCounters(msisdn, date, this.sequence(msisdn), originHostName, currency, operatorId));
ResponseCharing responseThresholdsCounter = parse.getParseXmlToObject(xmlThresholdsCounter);
ObjectCharingResponse responseCodeCounter = parse.getInformationMember(responseThresholdsCounter, "responseCode");
HashMap valHashMapResponseCodeCounter =   (HashMap) responseCodeCounter.getMemberValue().get(0);
valResponseCodeCounter = (String) valHashMapResponseCodeCounter.get(0);
if (Integer.parseInt(valResponseCodeCounter)>9)
valResponseCode="5";
}
}



String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));
cyclePayment.setResponseCode(valResponseCode);
cyclePayment.setDescription(nameError);
 return cyclePayment;
}

//Get balance and set limit credit
public ResponseUpdate getUpdateAmountLimit(String originId,String msisdn,String trxId,String amount, String ott) throws ParserConfigurationException, SAXException{
String responseUpdate="1";
String valResponseCode="0";

ResponseUpdate responseUpdateLimit= new ResponseUpdate();
String xmlUpdateResponse = poolHttp.doPost("http://172.17.240.234:10011/Air","fdsuser:fdsuser",this.xmlRequestUpdateRefill(msisdn, date, this.sequence(msisdn), originId, amount, currency));
ResponseCharing responseGetBalanceUpdate = parse.getParseXmlToObject(xmlUpdateResponse);
ObjectCharingResponse responseCodeUpdate = parse.getInformationMember(responseGetBalanceUpdate, "responseCode");
HashMap valHashMapResponseCodeUpdate =   (HashMap) responseCodeUpdate.getMemberValue().get(0);
responseUpdate = (String) valHashMapResponseCodeUpdate.get(0);
if (Integer.parseInt(responseUpdate)>9)
valResponseCode="6";

String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));
responseUpdateLimit.setResponseCode(valResponseCode);
responseUpdateLimit.setDescription(nameError);

return responseUpdateLimit;
}

public ResponseCurrentBalance getCurrentBalance(String originId,String msisdn,String trxId,String originHostName,String ott,long operatorId) throws ParserConfigurationException, SAXException{
String valResponseCode="1";
String valResponseCodeUpdate="1";
String valResponseCodeCounter="1";
String accountValue="1";
String monetaryValue="0";

HashMap informationList = new HashMap();
ResponseCurrentBalance cyclePayment= new ResponseCurrentBalance();

//Panama
//http://10.243.211.166:10011/Air

//Guatemala
//http://172.17.240.234:10011/Air

String xmlResponse = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetBalance(msisdn, date, sequence(msisdn), originHostName));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse dedicatedAccountInformation = parse.getInformationMember(responseGetBalance, "dedicatedAccountInformation");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
valResponseCode = (String) valHashMapResponseCode.get(0);

if (Integer.parseInt(valResponseCode)>0){
 String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));    
 cyclePayment.setResponseCode(valResponseCode);
 cyclePayment.setDescription(nameError);
 return cyclePayment;
}

int sizeObjectCharingAccountInformation = dedicatedAccountInformation.getMemberValue().size();

for (int index=0;index<sizeObjectCharingAccountInformation;index++){        
    HashMap value =    (HashMap) dedicatedAccountInformation.getMemberValue().get(index);    
    int valId = Integer.parseInt((String) value.get("dedicatedAccountID"));
    switch(valId){
        case 50120:            
             accountValue = (String) value.get("dedicatedAccountActiveValue1");             
             break;   
    }    
}

//"http://10.243.211.166:10011/Air","fdsuser:fdsuser"

String xmlThresholdsCounter = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlUsageThresholdsAndCounters(msisdn, date, this.sequence(msisdn), originHostName, currency, operatorId));
ResponseCharing responseThresholdsCounter = parse.getParseXmlToObject(xmlThresholdsCounter);
ObjectCharingResponse responseCodeCounter = parse.getInformationMember(responseThresholdsCounter, "responseCode");
ObjectCharingResponse usageCounterMonetaryValue1 = parse.getInformationMember(responseThresholdsCounter, "usageCounterUsageThresholdInformation");

HashMap valHashMapResponseCodeCounter =   (HashMap) responseCodeCounter.getMemberValue().get(0);
valResponseCode = (String) valHashMapResponseCodeCounter.get(0);


if (Integer.parseInt(valResponseCode)>0){
String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode)); 
cyclePayment.setResponseCode(valResponseCode);
 cyclePayment.setDescription(nameError);
 return cyclePayment;
}

int sizeObjectUsageCounterMonetaryValue = usageCounterMonetaryValue1.getMemberValue().size();

for (int index=0;index<sizeObjectUsageCounterMonetaryValue;index++){        
    HashMap valHash =    (HashMap) usageCounterMonetaryValue1.getMemberValue().get(index);  
    HashMap valCounter = (HashMap) valHash.get(0);  
    int valId = Integer.parseInt((String) valCounter.get("usageCounterID"));
    switch(valId){
        case 50120:            
             monetaryValue = (String) valCounter.get("usageCounterMonetaryValue1");             
             break;   
    }    
}
    
    cyclePayment.setCurrentBalance(accountValue);
    cyclePayment.setUsageBalance(monetaryValue);
    String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));
    cyclePayment.setResponseCode(valResponseCode);
    cyclePayment.setDescription(nameError);

    return cyclePayment;
}

//GetUsageThresholdsAndCounters
public ResponseCurrentBalance getThresholdsAndCounters(String origin, String msisdn){
String valResponseCode="1";

ResponseCurrentBalance cyclePayment= new ResponseCurrentBalance();
 
 try {
         
//Panama
//http://10.243.211.166:10011/Air

//Guatemala
//http://172.17.240.234:10011/Air

String xmlResponse = poolHttp.doPost("http://10.243.211.166:10011/Air","fdsuser:fdsuser",this.xmlRequestGetUsageThresholdsAndCounters(msisdn, date, sequence(msisdn), origin));

ResponseCharing responseGetBalance = parse.getParseXmlToObject(xmlResponse);

ObjectCharingResponse responseCode = parse.getInformationMember(responseGetBalance, "responseCode");
ObjectCharingResponse dedicatedAccountInformation = parse.getInformationMember(responseGetBalance, "dedicatedAccountInformation");

HashMap valHashMapResponseCode =   (HashMap) responseCode.getMemberValue().get(0);
valResponseCode = (String) valHashMapResponseCode.get(0);

if (Integer.parseInt(valResponseCode)>0){
    String nameError = (String) responseCodeCharing.getReponse().get(Integer.parseInt(valResponseCode));
    cyclePayment.setResponseCode(valResponseCode);
    cyclePayment.setDescription(nameError);
    return cyclePayment;
}


    } catch (ParserConfigurationException ex) {
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SAXException ex) {
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
    }
    
return cyclePayment;
}


public String sequence(String number){
     String sequence="";
     String ultimateDigits="";
     if(number.length()>=3){
     ultimateDigits = number.substring(number.length()-3);
     }else{
     ultimateDigits="000";
     }
     DateFormat newFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
     Date date = new Date();
     sequence = newFormat.format(date).trim()+ultimateDigits;

return sequence;
}


}
