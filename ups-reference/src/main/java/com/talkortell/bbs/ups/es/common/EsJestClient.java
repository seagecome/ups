package com.talkortell.bbs.ups.es.common;

import com.google.gson.GsonBuilder;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

public class EsJestClient {
	private static final String ES_HOST = "http://172.30.16.10";  
    private static final int ES_HTTP_PORT = 9200;  
    private static JestClient client;
    
    public static synchronized JestClient getClient() {
    	if(client == null) {
    		build();
    	}
    	return client;
    }
    
    private static void build() {
    	JestClientFactory factory = new JestClientFactory();
    	factory.setHttpClientConfig(new HttpClientConfig.Builder(ES_HOST+":"+ES_HTTP_PORT)
    			.multiThreaded(true)
    			.defaultMaxTotalConnectionPerRoute(2)
    			.maxTotalConnection(2)
    			.connTimeout(15000)
    			.readTimeout(15000)
    			.gson(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create())
    			.build());
    	client = factory.getObject();
    }
}
