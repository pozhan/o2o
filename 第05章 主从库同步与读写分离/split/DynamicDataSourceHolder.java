package com.imooc.o2o.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 辅助进行读写分离操
 * @author zhang
 *
 */
public class DynamicDataSourceHolder {
	private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
	private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();//线程安全类
	
	static final String DB_MASTER = "master";
	static final String DB_SLAVE= "slave";
	
	static String getDbType() {
		String db = contextHolder.get();
		if(db == null) {
			//默认使用
			db = DB_MASTER;
		}
		return db;
	}
	static void setDbType(String dbstr) {
		logger.debug("所使用的数据源是："+dbstr);
		contextHolder.set(dbstr);
	}
	/**
	 * 清理连接类型
	 */
	private static void clearDbType() {
		contextHolder.remove();
	
	}
}
