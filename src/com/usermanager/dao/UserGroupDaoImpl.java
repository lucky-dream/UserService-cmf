package com.usermanager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.usermanager.entity.Groups;
import com.usermanager.entity.UserGroup;

public class UserGroupDaoImpl implements UserGroupDao {

	@Override
	public List<UserGroup> getGroupsList(SqlSession sqlSession) {
		String statement = "com.usermanager.mappers.FriendUserMapper.getGroupsList";
		List groupList=sqlSession.selectList(statement);
		return groupList;
	}

	@Override
	public List<UserGroup> joinedGroupByName(SqlSession sqlSession, String name) {
		String statement = "com.usermanager.mappers.FriendUserMapper.joinedGroupByName";
		List joinedGroupList=sqlSession.selectList(statement);
		return joinedGroupList;
	}

	@Override
	public String getGroupNameById(SqlSession sqlSession, String id) {
		String statement = "com.usermanager.mappers.FriendUserMapper.getGroupNameById";
		String groupName=sqlSession.selectOne(statement, id);
		return groupName;
	}

	@Override
	public int createGroups(SqlSession sqlSession, Groups groups) {
		int rowNum=0;
		String statement = "com.usermanager.mappers.FriendUserMapper.createGroups";
		rowNum=sqlSession.update(statement);
		return rowNum;
	}

	@Override
	public int addGroupMembers(SqlSession sqlSession, UserGroup userGroup) {
		int rowNum=0;
		String statement = "com.usermanager.mappers.FriendUserMapper.addGroupMembers";
		rowNum=sqlSession.update(statement);
		return rowNum;
	}

	@Override
	public List<UserGroup> searchGroup(SqlSession sqlSession, String keywords) {
		String statement = "com.usermanager.mappers.FriendUserMapper.searchGroup";
		List<UserGroup> groupList=sqlSession.selectList(statement, keywords);
		return groupList;
	}

	@Override
	public int deleteGroup(SqlSession sqlSession, String id) {
		int rowNum=0;
		String statement = "com.usermanager.mappers.FriendUserMapper.deleteGroup";
		rowNum=sqlSession.update(statement,id);
		return rowNum;
	}

	@Override
	public int deleteGr(SqlSession sqlSession, String id) {
		int rowNum=0;
		String statement = "com.usermanager.mappers.FriendUserMapper.deleteGr";
		rowNum=sqlSession.update(statement,id);
		return rowNum;
	}


	

}
