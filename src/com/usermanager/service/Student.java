package com.usermanager.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;

public class Student {
	private String name;
	//年龄
	private String age;
	//住址
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address="
		+ address + "]";
		}
	public static void main(String[] args) {
		//定义两种不同格式的字符串
		//String objectStr="{\"name\":\"JSON\"}";
		//String arrayStr="[{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}]";
		//1、使用JSONObject
		//JSONObject jsonObject=JSONObject.fromObject(objectStr);
		//Student stu=(Student)JSONObject.toBean(jsonObject, Student.class);
		//2、使用JSONArray
		//JSONArray jsonArray=JSONArray.fromObject(arrayStr);
		//获得jsonArray的第一个元素
		//Object o=jsonArray.get(0);
		//JSONObject jsonObject2=JSONObject.fromObject(o);
		//Student stu2=(Student)JSONObject.toBean(jsonObject2, Student.class);
		//System.out.println("stu:"+stu);

		//System.out.println("stu2:"+stu2);
		
		String status="[{\"status\": \"0\"}]";
        JSONArray jsonArray = JSONArray.fromObject(status);
	    String  os = jsonArray.toString();
		 
		System.out.println(os);
		 

	}

}
