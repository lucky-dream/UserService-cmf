package com.usermanager.entity;

public class User {
        private Integer id;
        private String name;
        private String password;
        private String email;
        private Integer sex;
        private String sign;
        private String friend_tablename;
        
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Integer getSex() {
			return sex;
		}
		public void setSex(Integer sex) {
			this.sex = sex;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
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

		public String getFriend_tablename() {
			return friend_tablename;
		}
		public void setFriend_tablename(String friend_tablename) {
			this.friend_tablename = friend_tablename;
		}
		
		public void Print()
		{
			System.out.println(id+" "+name+" "+password+" "+email+" "+sex+" "+sign);
		}
        
}
