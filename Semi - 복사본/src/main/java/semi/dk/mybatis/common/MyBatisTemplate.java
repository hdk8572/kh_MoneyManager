package semi.dk.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {

	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis/mybatis-config.xml";
		InputStream is = null;
		SqlSessionFactory factory = null;
		SqlSessionFactoryBuilder builder = null;
		try {
			is = Resources.getResourceAsStream(resource);
			builder = new SqlSessionFactoryBuilder();
			factory = builder.build(is);
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		System.out.println("session :"+session);
		return session;
	}
}
