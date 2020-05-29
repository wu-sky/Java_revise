package com.sky.bean;


import java.util.Date;

/**
 * 用户实体类，相当于MVC里的M(物理模型)	
 * @author Administrator
 */

public class User implements Comparable<User>{

	private Long id;
	private String name;
	private Integer sex;
	private Date birthday;
	private String username;
	private String password;
	private Integer loginFlag;
	private Long roleId;
	private String filePath;
	private Date createDate;

	public User() {
	}

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(Integer loginFlag) {
		this.loginFlag = loginFlag;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", username=" + username
				+ ", loginFlag=" + loginFlag
				+ ", roleId=" + roleId + ", filePath=" + filePath
				+ "]";
	}

	@Override
	public int compareTo(User o) {
		//id在小的排前面
		int i= (int) (this.getId()-o.getId());
		return i;
	}
}
