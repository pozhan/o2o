package com.imooc.o2o.entity;

import java.util.Date;

public class ProductImg {
//	1-图片详情ID
	private long productImgId;
//	2-连接地址
	private String imgAddr;
//	3-图片描述
	private String imgDesc;
//	4-权重
	private Integer priority;
//	5-创建时间
	private Date createTime;
//  6-商品ID
	private long productId;
	
	public long getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(long productImgId) {
		this.productImgId = productImgId;
	}
	public String getImgAddr() {
		return imgAddr;
	}
	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}
	public String getImgDesc() {
		return imgDesc;
	}
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
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
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	
	 

}
