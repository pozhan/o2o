package com.imooc.o2o.entity;

import java.util.Date;

public class ShopCategory {
//	 1-ID
	private long shopCategory;
//	 2-名称
	private String shopCategoryname;
//	 3-权重
	private Integer priority;
//	 4-上级ID
	private ShopCategory parent;
//	 5-描述
	private String shopCategoryDesc;
//	 6-图片
	private String shopCategoryImg;
//	 7-创建时间
	private Date createTime;
//	 8-修改时间
	private Date lastEditTime;
	
	public long getShopCategory() {
		return shopCategory;
	}
	public void setShopCategory(long shopCategory) {
		this.shopCategory = shopCategory;
	}
	public String getShopCategoryname() {
		return shopCategoryname;
	}
	public void setShopCategoryname(String shopCategoryname) {
		this.shopCategoryname = shopCategoryname;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public ShopCategory getParent() {
		return parent;
	}
	public void setParent(ShopCategory parent) {
		this.parent = parent;
	}
	public String getShopCategoryDesc() {
		return shopCategoryDesc;
	}
	public void setShopCategoryDesc(String shopCategoryDesc) {
		this.shopCategoryDesc = shopCategoryDesc;
	}
	public String getShopCategoryImg() {
		return shopCategoryImg;
	}
	public void setShopCategoryImg(String shopCategoryImg) {
		this.shopCategoryImg = shopCategoryImg;
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
