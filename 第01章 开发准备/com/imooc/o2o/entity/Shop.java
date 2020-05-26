package com.imooc.o2o.entity;

import java.util.Date;

public class Shop {	 	 
//	 1-ID
	 private long shopId;
//	 2-店名
	 private String shopName;
//	 3-权重
	 private Integer priority;
//	 4-门面照
	 private String shopImg;
//	 5-描述
	 private String shopDesc;
//	 6-联系方式
	 private String phone;
//	 7-地址	
	 private String shopAddr;
//	 8-区域ID
	 private Area area;
//	 9-类别ID
	 private ShopCategory shopCategory;
//	 10-用户ID
	 private PersonInfo owner;
//	 11-状态: -1不可用 0审核中 1可用
	 private Integer enableStatus;
//	 12-建议: 超级管理员给店家的提醒
	 private String advice;
//	 13-创建时间
	 private Date createTime;	
//	 14-修改时间
	 private Date lastEditTime;
	 
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public String getShopDesc() {
		return shopDesc;
	}
	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShopAddr() {
		return shopAddr;
	}
	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public ShopCategory getShopCategory() {
		return shopCategory;
	}
	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}
	public PersonInfo getOwner() {
		return owner;
	}
	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
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
