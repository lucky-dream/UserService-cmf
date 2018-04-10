package com.usermanager.service;

import java.net.InetSocketAddress;


public interface UserServiceHttpService {
	//
     public boolean init(Object inetSocketAddress,int num);
     
     public Object createContext(String str,Object handler);
     public Object createDefultContext(Object handler);
     public void start();
     public void close(int delayTime);
     
}
