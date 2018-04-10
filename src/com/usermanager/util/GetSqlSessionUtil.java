package com.usermanager.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;

public class GetSqlSessionUtil {
	
	private ApplicationContext applicationContext =ApplicationContextUtil.getInstance();
	
	public SqlSession getSqlSession(){
		
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)applicationContext.getBean("sqlSessionFactory");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
		
	}
	

}
