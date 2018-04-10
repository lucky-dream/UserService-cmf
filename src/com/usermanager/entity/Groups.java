package com.usermanager.entity;

public class Groups {
	
	private String id;
	private String groupId;
	private String groupName;
	
	public Groups() {
		super();
	}

	public Groups(String id, String groupId, String groupName) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
