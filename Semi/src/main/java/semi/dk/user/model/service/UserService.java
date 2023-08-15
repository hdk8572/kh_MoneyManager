package semi.dk.user.model.service;

import static semi.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.util.List;

import semi.dk.user.model.dao.UserDao;
import semi.dk.user.model.dto.UserDto;

public class UserService {

	private UserDao dao = new UserDao();

	public List<UserDto> selectList() {
		List<UserDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	
	public List<UserDto> InsertGetList(UserDto dto) {
		List<UserDto> result = null;
		Connection conn = getConnection();
		int result1 = dao.Insert(conn, dto);
		if(result1 > 0) {
			System.out.println("입력 성공");
			result = dao.selectList(conn);
		} else {
			System.out.println("입력 실패");
		}
		close(conn);
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
		Connection conn = getConnection();
		result = dao.delete(conn, mno);
		close(conn);
		return result;
	}
}
