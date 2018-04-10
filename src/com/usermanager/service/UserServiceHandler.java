package com.usermanager.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UserServiceHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		//获取header
		Headers header=httpExchange.getRequestHeaders();
		
		String userId=header.getFirst("lf-uid");
		//获取url
		Map<String,String> urlMap=new HashMap<String, String>();
		URI url=httpExchange.getRequestURI();
		String urlRe=url.toString();
		int questionMark=urlRe.indexOf("?");
		String newUrlValues=urlRe.substring(questionMark+1, urlRe.length());
		String[] urlAndValues=newUrlValues.split("&");
		for(int num=0;num<urlAndValues.length;num++){
			int equesMark=urlAndValues[num].indexOf("=");
			String key=urlAndValues[num].substring(0, equesMark);
			String value=urlAndValues[num].substring(equesMark+1);	
			urlMap.put(key, value);
			}
		//获取body
		InputStream requestStream=httpExchange.getRequestBody();
		String streamStrBody=requestStream.toString();
		//处理业务
		TaskAllocation taskAllocation=new TaskAllocation();
		taskAllocation.taskDistribution(userId,urlMap,streamStrBody);
	    //response处理
		
		
		

	}
	

}
