package com.usermanager.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;

import com.usermanager.dao.FriendUserDao;
import com.usermanager.dao.FriendUserDaoImpl;
import com.usermanager.dao.UserDao;
import com.usermanager.dao.UserDaoImpl;
import com.usermanager.dao.UserGroupDao;
import com.usermanager.dao.UserGroupDaoImpl;
import com.usermanager.entity.FriendUser;
import com.usermanager.entity.Groups;
import com.usermanager.entity.User;
import com.usermanager.entity.UserGroup;
import com.usermanager.entity.UserSearch;
import com.usermanager.util.GetSqlSessionUtil;
import com.usermanager.util.QueryUtil;
import com.usermanager.util.ResultSetUtil;

public class TaskAllocation {

	// 获取业务对象
	UserDao userDaoImpl;
	FriendUserDao friendUserDao;
	UserGroupDao userGroupDao;
	private FriendUser friendUser = new FriendUser();
	String userId;
	String streamStrBody;
	String josnReturnStrng;//返回的josn

	public void taskDistribution(String userId, Map<String, String> urlMap,
			String streamStrBody) {
		this.userId = userId;
		this.streamStrBody=streamStrBody;
		userDaoImpl = new UserDaoImpl();
		friendUserDao = new FriendUserDaoImpl();
		userGroupDao = new UserGroupDaoImpl();
		// 获取sqlSession
		GetSqlSessionUtil getSqlSessionUtil = new GetSqlSessionUtil();
		SqlSession sqlSession = getSqlSessionUtil.getSqlSession();
		// 获取op的值 不同op对应不同业务
		String opValue = urlMap.get("op");
		// 分派任务
		if (opValue == "ulist") {// 获取用户列表（当前仅超级管理员）

			getUserList(sqlSession, streamStrBody);

		} else if (opValue == "fulist") {// 获取好友列表

			getFriendList(userId, sqlSession);

		} else if (opValue == "usearch") {// 用户搜索 解析body

			searchUser(sqlSession);

		} else if (opValue == "fuadd") {// 添加好友

			addFriend(sqlSession, friendUser);

		} else if (opValue == "fudel") {// 删除好友

			deleteFriend(sqlSession);

		} else if (opValue == "aglist") {// 获取所有组列表（当前仅超级管理员）

			getGroupsList(sqlSession);

		} else if (opValue == "glist") {// 获取已加入组列表

			joinedGroupByName(sqlSession);

		} else if (opValue == "addg") {// 创建组
			createGroups(userId, sqlSession);

		} else if (opValue == "gsearch") {// 搜索组
			searchGroup(sqlSession);

		} else if (opValue == "joing") {// 加入组

		} else if (opValue == "delg") {// 删除组
			deleteGroup(userId, sqlSession);

		}

	}

	public void deleteGroup(String userId, SqlSession sqlSession) {

		int rowNumGr = 0;
		int rowNumGroup = 0;
		rowNumGr = userGroupDao.deleteGr(sqlSession, userId);// 删除组总表
		rowNumGroup = userGroupDao.deleteGroup(sqlSession, userId);
		if (rowNumGr > 0 && rowNumGroup > 0) {
			// 成功
		} else {
			// 失败
		}
	}

	public List<UserGroup> searchGroup(SqlSession sqlSession) {
		// ===========keywords 用户输入
		String keywords = null;
		return userGroupDao.searchGroup(sqlSession, keywords);

	}

	public void createGroups(String userId, SqlSession sqlSession) {
		int rowNumGr = 0;
		int rowNumGroup = 0;
		Groups groups = new Groups();
		groups.setGroupId(userId);
		// ===========groupName 用户输入
		String groupName = null;
		groups.setGroupName(groupName);
		rowNumGr = userGroupDao.createGroups(sqlSession, groups);
		UserGroup userGroup = new UserGroup();
		userGroup.setId(userId);
		userGroup.setName(groupName);
		userGroup.setOwner("1");
		// ===========sign 用户输入
		String sign = null;
		userGroup.setSign(sign);
		rowNumGroup = userGroupDao.addGroupMembers(sqlSession, userGroup);

		if (rowNumGr > 0 && rowNumGroup > 0) {
			// 成功
		} else {
			// 失败
		}
	}

	public List<UserGroup> joinedGroupByName(SqlSession sqlSession) {
		String userName = getCurrentNameById(sqlSession,userId);
		return userGroupDao.joinedGroupByName(sqlSession, userName);
	}

	public List<UserGroup> getGroupsList(SqlSession sqlSession) {
		return userGroupDao.getGroupsList(sqlSession);
	}

	public void deleteFriend(SqlSession sqlSession) {
		int rowNumU = 0;
		int rowNumF = 0;
		String friend_Name = null;// 传入的好友name
		friendUser.setFriend_Name(friend_Name);
		friendUser.setFriend_TableName("fritable" + friend_Name);
		rowNumU = friendUserDao.deleteFriend(sqlSession, friendUser);
		FriendUser friendUser2 = new FriendUser();
		String userName = getCurrentNameById(sqlSession,userId);
		friendUser2.setFriend_Name(userName);
		friendUser2.setFriend_TableName("fritable" + userName);
		rowNumF = friendUserDao.deleteFriend(sqlSession, friendUser);
		if (rowNumU > 0 && rowNumF > 0) {
			// 添加成功
		} else {
			// 添加失败
		}
	}
//?
	public String addFriend(SqlSession sqlSession, FriendUser friendUser) {
		int rowNumU = 0;
		int rowNumF = 0;
		//给自己的friend表加入好友id
		JSONObject jsonObject=JSONObject.fromObject(streamStrBody);
		friendUser=(FriendUser)JSONObject.toBean(jsonObject, UserSearch.class);
		//
		friendUser.setFriend_TableName("fritable" + QueryUtil.getNameById(sqlSession, userId));
		friendUser.setFriend_Id(QueryUtil.getIdByName(sqlSession, friendUser.getFriend_Name()));
		rowNumU = friendUserDao.addFriend(sqlSession, friendUser);
		//在好友的好友表中添加uid
		FriendUser friendUser1 = new FriendUser();
		friendUser1.setFriend_Id(userId);
		friendUser1.setFriend_TableName("fritable"+friendUser.getFriend_Name() );
		rowNumF = friendUserDao.addFriend(sqlSession, friendUser1);
		if (rowNumU > 0 && rowNumF > 0) {
			// 添加成功
            String status="[{\"status\": \"0\"}]";
            JSONArray jsonArray = JSONArray.fromObject(status);
			return jsonArray.toString();
		} else {
			String status="[{\"status\":\"400\",\"info\":\"添加失败\"]";
			// 添加失败
		}
		return josnReturnStrng;

	}

	public String searchUser(SqlSession sqlSession) {
		//使用JSONArray
		JSONObject jsonObject=JSONObject.fromObject(streamStrBody);
		UserSearch userSearch=(UserSearch)JSONObject.toBean(jsonObject, UserSearch.class);
		List<User> userSearchs = friendUserDao.searchUser(sqlSession, userSearch);
		JSONArray listArray=JSONArray.fromObject(userSearchs);
		josnReturnStrng=listArray.toString();
		return josnReturnStrng;
	}

	public String getFriendList(String userId, SqlSession sqlSession) {
		friendUser.setFriend_TableName("fritable" + userId);
		List<User> userFriends = friendUserDao.getFriendList(sqlSession,
				friendUser.getFriend_TableName());
		JSONArray listArray=JSONArray.fromObject(userFriends);
		josnReturnStrng=listArray.toString();
		return josnReturnStrng;
	}

	public String getUserList(SqlSession sqlSession, String streamStrBody) {
		List<User> users = userDaoImpl.getUserList(sqlSession);
		JSONArray listArray=JSONArray.fromObject(users);
		josnReturnStrng=listArray.toString();
		return josnReturnStrng;
	}

	/**
	 * 获取当前id的name
	 * 
	 * @param sqlSession
	 * @return
	 */
	public String getCurrentNameById(SqlSession sqlSession,String id) {
		UserDao userDao = new UserDaoImpl();
		String userName = userDao.searchIdByName(sqlSession, userId);
		return userName;
	}

}
