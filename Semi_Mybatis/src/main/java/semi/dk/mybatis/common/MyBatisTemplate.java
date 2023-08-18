package semi.dk.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {

	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;
		String resource = "mybatis/mybatis-config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession(autoCommit);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		System.out.println("session :"+session);
		return session;
	}
}


//if (is == null) {
//System.out.println("연결 실패");
//} else {
//System.out.println("resource랑 연결 성공 :"+ is);
//}
//builder = new SqlSessionFactoryBuilder();
//factory = builder.build(is);
//System.out.println("factory :"+ factory);