package com.imooc.o2o.entity;

import java.util.Date;

public class WechatAuth {
//	 1-ID
	private long wechatAuthId;
//	 2-用户ID--主外键
	private PersonInfo personInfo;
//	 3-创建时间
	private Date createTime;
//	 4-绑定标识openId
	private String openId;
	
	public long getWechatAuthId() {
		return wechatAuthId;
	}
	public void setWechatAuthId(long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	
}
