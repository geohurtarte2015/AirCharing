package com.controller;

import static com.google.common.base.Preconditions.checkArgument;
import java.io.IOException;


import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;


import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.codec.binary.Base64;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.xml.sax.SAXException;


/**
 * 
 * @author Edgar Giovanni Hurtarte
 *
 */
public class PoolHttp {

	private static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 1024;
        private static final String CHARSET = "UTF-8";

	private static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = DEFAULT_MAX_TOTAL_CONNECTIONS;

	private static final int DEFAULT_CONNECTION_TIMEOUT_MILLISECONDS = (10 * 1000);
	private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = (10 * 1000);
	private static final int DEFAULT_WAIT_TIMEOUT_MILLISECONDS = (10 * 1000);

	private static final int DEFAULT_KEEP_ALIVE_MILLISECONDS = (5 * 60 * 1000);

	private static final String DEFAULT_CHARSET = "UTF-8";

	private static final int DEFAULT_RETRY_COUNT = 2;

	private int keepAlive = DEFAULT_KEEP_ALIVE_MILLISECONDS;

	private int maxTotalConnections = DEFAULT_MAX_TOTAL_CONNECTIONS;
	private int maxConnectionsPerRoute = DEFAULT_MAX_CONNECTIONS_PER_ROUTE;

	private int connectTimeout = DEFAULT_CONNECTION_TIMEOUT_MILLISECONDS;
	private int readTimeout = DEFAULT_READ_TIMEOUT_MILLISECONDS;
	private int waitTimeout = DEFAULT_WAIT_TIMEOUT_MILLISECONDS;

	private int retries = DEFAULT_RETRY_COUNT;
        

	private PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

	private CloseableHttpClient httpClient = null;

	private ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
		@Override
		public long getKeepAliveDuration(HttpResponse response,
				HttpContext context) {
			HeaderElementIterator it = new BasicHeaderElementIterator(
					response.headerIterator(HTTP.CONN_KEEP_ALIVE));
			while (it.hasNext()) {
				HeaderElement he = it.nextElement();
				String param = he.getName();
				String value = he.getValue();
				if (value != null && param.equalsIgnoreCase("timeout")) {
					return Long.parseLong(value) * 1000;
				}
			}
			return keepAlive;
		}
	};

	public PoolHttp() {
		// Increase max total connection
		connManager.setMaxTotal(maxTotalConnections);
		// Increase default max connection per route
		connManager.setDefaultMaxPerRoute(maxConnectionsPerRoute);

		// config timeout
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(connectTimeout)
				.setConnectionRequestTimeout(waitTimeout)
				.setSocketTimeout(readTimeout).build();

		httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrategy)
				.setConnectionManager(connManager)
				.setDefaultRequestConfig(config).build();

		// detect idle and expired connections and close them
		IdleConnectionMonitorThread staleMonitor = new IdleConnectionMonitorThread(
				connManager);
		staleMonitor.start();
	}

        /*ACA INICIA LA TRANSACCION */
	public  String doPost(String url, String user, String data) throws ParserConfigurationException, SAXException{    
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
                    HttpResponse  response = execute(post);
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
    
        private static String getResponseCharset(String ctype) 
        {
		String charset = DEFAULT_CHARSET;

		if (!StringUtils.isEmpty(ctype)) {
			String[] params = ctype.split(";");
			for (String param : params) {
				param = param.trim();
				if (param.startsWith("charset")) {
					String[] pair = param.split("=", 2);
					if (pair.length == 2) {
						if (!StringUtils.isEmpty(pair[1])) {
							charset = pair[1].trim();
						}
					}
					break;
				}
			}
		}

		return charset;
	}

	public HttpResponse execute(HttpUriRequest request) throws IOException {
		HttpResponse response;

		int tries = ++retries;
		while (true) {
			tries--;
			try {
				response = httpClient.execute(request);
				break;
			} catch (IOException e) {
				if (tries < 1)
					throw e;
			}
		}

		return response;
	}

	public void shutdown() throws IOException {
		httpClient.close();
	}

	public int getKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(int keepAlive) {
		this.keepAlive = keepAlive;
	}

	public int getMaxTotalConnections() {
		return maxTotalConnections;
	}

	public void setMaxTotalConnections(int maxTotalConnections) {
		this.maxTotalConnections = maxTotalConnections;
	}

	public int getMaxConnectionsPerRoute() {
		return maxConnectionsPerRoute;
	}

	public void setMaxConnectionsPerRoute(int maxConnectionsPerRoute) {
		this.maxConnectionsPerRoute = maxConnectionsPerRoute;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public int getWaitTimeout() {
		return waitTimeout;
	}

	public void setWaitTimeout(int waitTimeout) {
		this.waitTimeout = waitTimeout;
	}

	public PoolingHttpClientConnectionManager getConnManager() {
		return connManager;
	}

	public void setConnManager(PoolingHttpClientConnectionManager connManager) {
		this.connManager = connManager;
	}

	public int getRetryCount() {
		return retries;
	}

	public void setRetryCount(int retries) {
		checkArgument(retries >= 0);
		this.retries = retries;
	}

	public static class IdleConnectionMonitorThread extends Thread {

		private final HttpClientConnectionManager connMgr;
		private volatile boolean shutdown;

		public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
			super();
			this.connMgr = connMgr;
		}

		@Override
		public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						// Close expired connections
						connMgr.closeExpiredConnections();
						// Optionally, close connections
						// that have been idle longer than 60 sec
						connMgr.closeIdleConnections(60, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
				// terminate
				shutdown();
			}
		}

		public void shutdown() {
			shutdown = true;
			synchronized (this) {
				notifyAll();
			}
		}

	}
}