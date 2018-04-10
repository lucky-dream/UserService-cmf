package com.usermanager.util;

import org.apache.ibatis.session.SqlSession;

import com.usermanager.dao.UserDao;
import com.usermanager.dao.UserDaoImpl;

public class QueryUtil {
	private static UserDao  userDao=new UserDaoImpl();
	//通过id查找name
	public static  String getNameById(SqlSession sqlSession,String id){
		return userDao.searchNameById(sqlSession, id);
	}
	//通过name查找id
	public static String getIdByName(SqlSession sqlSession,String name){
		return userDao.searchNameById(sqlSession, name);
	}

}
