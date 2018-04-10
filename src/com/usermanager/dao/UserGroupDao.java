package com.usermanager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.usermanager.entity.Groups;
import com.usermanager.entity.UserGroup;

public interface UserGroupDao {
	//获取所以组列表
	public List<UserGroup> getGroupsList(SqlSession sqlSession);
	//获取已加入组列表
	public List<UserGroup> joinedGroupByName(SqlSession sqlSession,String name);
	//根据组id查询组名
	public String getGroupNameById(SqlSession sqlSession,String id);
    //用户创建组 
	public int createGroups(SqlSession sqlSession,Groups groups);
	public int addGroupMembers(SqlSession sqlSession,UserGroup userGroup);
	//搜索组
	public List<UserGroup> searchGroup(SqlSession sqlSession,String keywords);
	//删除组
	public int deleteGroup(SqlSession sqlSession,String id);
	public int deleteGr(SqlSession sqlSession,String id);
	
}
