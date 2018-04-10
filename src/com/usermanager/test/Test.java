package com.usermanager.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.usermanager.dao.UserDao;
import com.usermanager.dao.UserDaoImpl;
import com.usermanager.entity.User;
import com.usermanager.util.GetSqlSessionUtil;

public class Test {
 public static void main(String[] args) {
	 UserDao userDao = new UserDaoImpl();
	 User user = new User();
	 //userDao.login(user).Print();
	 GetSqlSessionUtil getSqlSessionUtil=new GetSqlSessionUtil();
	 SqlSession sqlSession=getSqlSessionUtil.getSqlSession();
	 List<User> userList=userDao.getUserList(sqlSession);
	 for (User user2 : userList) {
		System.out.println(user2.getId());
		System.out.println(user2.getEmail());
		System.out.println(user2.getName());
	}
  }
}
