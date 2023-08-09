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
	
	public int InsertList(UserDto dto) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.InsertList(conn, dto);
		close(conn);
		return result;
	}
}