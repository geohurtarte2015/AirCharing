
package com.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.xml.sax.SAXException;

/**
 *
 * @author LENOVO
 */
public class Connection {
    
    private static Connection INSTANCE = null;   
    private static final String CHARSET = "UTF-8";
    private static final int DEFAULT_RETRY_COUNT = 2;
    private int retries = DEFAULT_RETRY_COUNT;
    private CloseableHttpClient httpClient = null;
        
    private Connection(){}
    
    public static Connection getInstance(){
    if(INSTANCE == null){
        synchronized(Connection.class){
           INSTANCE = new Connection();
        }
     
    }
    return INSTANCE;
    }

    protected static  String doPost(String url, String user, String data) throws ParserConfigurationException, SAXException{    
        String responseXml="Error response";
        int resp=0;
        SimpleHttpResponse simpleResponse = new SimpleHttpResponse();
          
         //int CONNECTION_TIMEOUT_MS = seconds * milliseconds
         //---------------------------------------------------------
          int CONNECTION_TIMEOUT_MS = 5 * 1000; // Timeout in millis.
          RequestConfig requestConfig = RequestConfig.custom()
              .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS)
              .setConnectTimeout(CONNECTION_TIMEOUT_MS)
              .setSocketTimeout(CONNECTION_TIMEOUT_MS)
              .build();
          //--------------------------------------------------------
            
            try {
                
                String       postUrl       = url;// put in your url       
                HttpClient   httpClient    = HttpClientBuilder.create().build();
                HttpPost     post          = new HttpPost(postUrl);
                post.setConfig(requestConfig);
                StringEntity postingString = new StringEntity(data);//gson.tojson() converts your pojo to json
                post.setEntity(postingString);                                
                post.setHeader("Content-Type", "text/xml");
                post.setHeader("User-Agent", "UGw Server/5.0/1.0");
                post.setHeader("Authorization", "Basic " + new String(Base64.encodeBase64(user.getBytes(CHARSET)), CHARSET));
                try {
                    HttpResponse  response = httpClient.execute(post);
                    responseXml = EntityUtils.toString(response.getEntity());
                                                        
                    //responseXml = EntityUtils.t
                    //System.out.println(responseXml);                   
                    resp=response.getStatusLine().getStatusCode();                    
                    simpleResponse.setStatusCode(resp);
                  //  System.out.println("Respuesta del Webservice: "+" "+url+" "+response.getStatusLine().getStatusCode());
                } catch (IOException ex) {
                    System.out.println("Error: "+ ex);
                }
                                    
                } catch (UnsupportedEncodingException ex) {
                 System.out.println("Error read URL: "+ ex);
                }
	
		return responseXml;
	
	}        
    
  
}
