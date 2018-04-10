package com.usermanager.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.usermanager.entity.User;


public interface UserDao {
	// 获取用户列表（当前仅超级管理员） 
	public List<User> getUserList(SqlSession sqlSession);
	
	//通过id查询name
	public String searchNameById(SqlSession sqlSession,String id);
	//通过name 查询id
	public String searchIdByName(SqlSession sqlSession,String name);
	//通过id查询某个用户所有信息 
	public User searchUserById(SqlSession sqlSession,String id);
	
	
}
