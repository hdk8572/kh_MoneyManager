package semi.dk.user.model.service;

import static semi.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import semi.dk.mybatis.common.MyBatisTemplate;
import semi.dk.user.model.dao.UserDao;
import semi.dk.user.model.dto.UserDto;

public class UserService {

	private UserDao dao = new UserDao();

	public List<UserDto> selectList() {
		List<UserDto> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.selectList(session);
		session.close();
		return result;
	}
	
	public int InsertGetList(UserDto dto) {
		int result = 0;
		SqlSession Session = MyBatisTemplate.getSqlSession();
		result = dao.Insert(Session, dto);
		Session.close();
		return result;
	}
	
	public UserDto selectOne(String insertDate) {
		UserDto result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, insertDate);
		close(conn);
		return result;
	}
	
	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(String mno){
		int result = 0;
		SqlSession Session = MyBatisTemplate.getSqlSession();
		result = dao.delete(Session, mno);
		Session.close();
		return result;
	}
}
