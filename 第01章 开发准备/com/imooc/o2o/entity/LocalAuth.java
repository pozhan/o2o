package com.imooc.o2o.entity;

import java.util.Date;

public class LocalAuth {
//	 1-ID
	private long localAuthId;
//	 2-用户ID--主外键
	private PersonInfo personInfo;
//	 3-用户名
	private String username;
//	 4-密码
	private String password; 
//	 5-创建时间
	private Date createTime;
//	 6-修改时间
	private Date lastEditTime;
	
	public long getLocalAuthId() {
		return localAuthId;
	}
	public void setLocalAuthId(long localAuthId) {
		this.localAuthId = localAuthId;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	
	
}
