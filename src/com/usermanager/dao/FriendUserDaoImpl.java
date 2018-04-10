package com.usermanager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.usermanager.entity.FriendUser;
import com.usermanager.entity.User;
import com.usermanager.entity.UserSearch;

public class FriendUserDaoImpl implements FriendUserDao {
	
	@Override
	public int addFriend(SqlSession sqlSession, FriendUser friendUser) {
		int rowNum=0;
		String statement = "com.usermanager.mappers.FriendUserMapper.searchUser";
		rowNum=sqlSession.update(statement, friendUser);
		return rowNum;
	}
	

	@Override
	public int deleteFriend(SqlSession sqlSession, FriendUser friendUser) {
		int rowNum=0;
		String statement = "com.usermanager.mappers.FriendUserMapper.deleteFriend";
		rowNum=sqlSession.update(statement, friendUser);
		return rowNum;
	}

	@Override
	public List<User> getFriendList(SqlSession sqlSession,String friend_tablename) {
		String statement = "com.usermanager.mappers.UserMapper.getUserList";
		List<User> userList=sqlSession.selectList(statement,friend_tablename);
		return userList;
	}
	
	@Override
	public List<User> searchUser(SqlSession sqlSession,UserSearch userSearch) {
		String statement = "com.usermanager.mappers.UserMapper.searchUser";
		List<User> userList=sqlSession.selectList(statement,userSearch);
		return userList;
	}
	
	
	
	
}
