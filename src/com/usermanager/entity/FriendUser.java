package com.usermanager.entity;

public class FriendUser {
	private String friend_TableName;
	private String friend_Id;
	private String friend_Name;
	

	public FriendUser() {
		super();
	}


	public FriendUser(String friend_TableName, String friend_Id,
			String friend_Name) {
		super();
		this.friend_TableName = friend_TableName;
		this.friend_Id = friend_Id;
		this.friend_Name = friend_Name;
	}


	public String getFriend_TableName() {
		return friend_TableName;
	}


	public void setFriend_TableName(String friend_TableName) {
		this.friend_TableName = friend_TableName;
	}


	public String getFriend_Id() {
		return friend_Id;
	}


	public void setFriend_Id(String friend_Id) {
		this.friend_Id = friend_Id;
	}


	public String getFriend_Name() {
		return friend_Name;
	}


	public void setFriend_Name(String friend_Name) {
		this.friend_Name = friend_Name;
	}
	
	
	
	

}
