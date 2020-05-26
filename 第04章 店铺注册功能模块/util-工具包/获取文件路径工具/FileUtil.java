package com.imooc.o2o.util;

public class FileUtil {
	//获取系统分隔符
	private static String seperator = System.getProperty("file.separator");
	/**
	 * 
	 * @return 返回项目图片根目录
	 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image/";
		}else {
			basePath = "/home/tupian/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	/**
	 * 
	 * @param shopId
	 * @return 店铺图片子地址
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/"+shopId+"/";
		return imagePath.replace("/", seperator);
	}

}
