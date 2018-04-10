package com.usermanager.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetUtil {
	public static <T>  T findById(ResultSet rs,Class<T> c){
		T object = null;
		try {
			if(rs.next()){
			  object = c.newInstance();
			  Field[] fields=c.getDeclaredFields();
				for (Field field : fields){
					field.setAccessible(true);
					field.set(object,rs.getObject(field.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public static <T>  List <T> findAll(ResultSet rs,Class<T> c){
		T object = null;
		 List <T> list= new ArrayList<T>(); 
		try {
			while(rs.next()){//反射的方法
			  object = c.newInstance();//实例化
			  Field[] fields=c.getDeclaredFields();//获取字段值
				for (Field field : fields){
					field.setAccessible(true);//获取私有变量
					field.set(object,rs.getObject(field.getName()));
				}
				
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
