package com.usermanager.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class UserServiceHttpServiceImpl implements UserServiceHttpService {
	int status=0;
	HttpServer hs;
    //初始化
	@Override
	public boolean init(Object address, int num) {	
		try {
			hs = HttpServer.create((InetSocketAddress)address,0);
			
		} catch (IOException e) {
			status=-1;
			return false;
		}
		status=1;//已初始化  返回1
		return true;
	}

	@Override
	public Object createContext(String str, Object handler) {
		Object obj=hs.createContext(str,(HttpHandler)handler);
		return obj;
	}

	@Override
	public Object createDefultContext(Object handler) {
		hs.setExecutor((Executor)handler);
		return null;
	}

	@Override
	public void start() {
		hs.start();
		status=2;//服务正在运行
	}

	@Override
	public void close(int delayTime) {
		hs.stop(delayTime);
		status=0;//正常关闭，未启动
	}

	public boolean isRunning(){	
		
		return status==2;
		
	}

}
