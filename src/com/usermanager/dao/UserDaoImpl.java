package com.usermanager.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.usermanager.entity.FriendUser;
import com.usermanager.entity.User;
import com.usermanager.util.ApplicationContextUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUserList(SqlSession sqlSession) {
		String statement = "com.usermanager.mappers.UserMapper.getUserList";//映射sql的标识字符串
		List<User> userList=sqlSession.selectList(statement);
		return userList;
	}

	

	@Override
	public String searchNameById(SqlSession sqlSession, String id) {
		String statement = "com.usermanager.mappers.UserMapper.searchNameById";
		String name=sqlSession.selectOne(statement, id);
		return name;
	}

	@Override
	public String searchIdByName(SqlSession sqlSession, String name) {
		String statement = "com.usermanager.mappers.UserMapper.searchIdByName";
		String id=sqlSession.selectOne(statement, name);
		return id;
	}

	@Override
	public User searchUserById(SqlSession sqlSession, String id) {
		String statement = "com.usermanager.mappers.UserMapper.searchUserById";
		List list=sqlSession.selectList(statement, id);
		return (User) list;
	}
	

}
