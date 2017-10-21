package service;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnector {
	SqlSessionFactory factory = null;
	private static MyBatisConnector connector = null;
	private MyBatisConnector() {
		try{
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			System.out.println("config read");
			factory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("factory made");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static MyBatisConnector getInstance() {
		if (connector == null) {
			connector = new MyBatisConnector();
		}
		return connector;
	}
	public SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
}