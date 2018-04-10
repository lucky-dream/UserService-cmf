package com.usermanager.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {

	private static ApplicationContext applicationContext;

	private ApplicationContextUtil() {
		
	}
	static {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}
	public static synchronized ApplicationContext getInstance() {
		return applicationContext;
	}

}
