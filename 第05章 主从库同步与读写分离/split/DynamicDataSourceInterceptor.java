package com.imooc.o2o.dao.split;

import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Mybatis拦截器，实现读写分离
 * @author zhang
 *
 */
@Intercepts({@Signature(type=Executor.class,method="update",args= {MappedStatement.class,Object.class}),
	@Signature(type=Executor.class,method="query",args= {MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})
public class DynamicDataSourceInterceptor implements Interceptor{
	private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
	private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";
	 /**
     * SQL语句拦截
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		//是否启用事务支持，检测@Transactional注解是否启用，启用这里就为true,否则为false
		boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();
		//获取sql的资源变量参数（增删改查的一些参数）
        Object[] objects = invocation.getArgs();
        //MappedStatement 可以获取到到底是增加还是删除 还是修改的操作
        MappedStatement ms = (MappedStatement) objects[0];
        //用来决定datasource的
        String lookupKey = DynamicDataSourceHolder.DB_MASTER;
        if (synchronizationActive != true) {
        	//读方法,说明是 select 查询操作
            if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
            	//如果selectKey 为自增id查询主键（select last_insert_id()方法，这个查询是自增主键的一个查询，使用主库
                if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                    lookupKey = DynamicDataSourceHolder.DB_MASTER;
                } else {
                    BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                    if (sql.matches(REGEX)) {
                        lookupKey = DynamicDataSourceHolder.DB_MASTER;
                    } else {
                        lookupKey = DynamicDataSourceHolder.DB_SLAVE;
                    }
                }
            }
        } else {
            lookupKey = DynamicDataSourceHolder.DB_MASTER;
        }
        logger.debug("设置方法[{}] use[{}] strategy,SqlCommandType[{}]..",ms.getId(),lookupKey,ms.getSqlCommandType());
        DynamicDataSourceHolder.setDbType(lookupKey);
        return invocation.proceed();
	}
	
	/**
     * 决定返回本体还是编织好的代理类,
     * 代理类会去调用intercept方法决定是使用主库还是从库
     *
     * @param target
     * @return
     */
	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}
	/**
     * 做一些相关的参数设置，不是关键
     *
     * @param properties
     */
	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}
	

}
