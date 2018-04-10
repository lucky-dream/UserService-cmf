package com.usermanager.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.usermanager.entity.FriendUser;
import com.usermanager.entity.User;
import com.usermanager.entity.UserSearch;

public interface FriendUserDao {
	    //添加好友
		public int addFriend(SqlSession sqlSession,FriendUser  friendUser);
		//删除好友
		public int deleteFriend(SqlSession sqlSession,FriendUser  friendUser);
		//获取好友列表
		public List<User> getFriendList(SqlSession sqlSession,String friend_tablename);
		//用户搜索
		public List<User> searchUser(SqlSession sqlSession,UserSearch userSearch);
}
