package com.imooc.o2o.entity;

import java.util.Date;

public class ProductCategory {
//	1-商品类别ID
	private long productCategoryId;
//	2-店铺ID
	private long shopId;
//	3-商品类别名称
	private String productCategoryName;
//	4-权重
	private Integer priority;
//	5-创建时间
	private Date createTime;
	
	public long getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	 
	 
	 
	 

}
