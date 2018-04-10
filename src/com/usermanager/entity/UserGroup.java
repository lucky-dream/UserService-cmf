package com.usermanager.entity;

public class UserGroup {
	private String id;
	private String name;
	private String password;
	private String sign;
	private String owner;//组的创建者
	private String group_table;

	public UserGroup() {
		super();
	}

	public UserGroup(String id, String name, String password, String sign,
			String owner) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sign = sign;
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getGroup_table() {
		return group_table;
	}

	public void setGroup_table(String group_table) {
		this.group_table = group_table;
	}

	
}
