package gagyebu.dk.common;

import static gagyebu.dk.common.DkTemplate.*;

import java.sql.Connection;

import gagyebu.dk.insertlist.model.Dao.InsertlistDao;
import gagyebu.dk.insertlist.model.Dto.InsertlistDto;
//import gagyebu.dk.insertlist.model.Dao.InsertlistDao;
import gagyebu.dk.member.model.dao.LoginDao;

public class DkService {

	private LoginDao logindao = new LoginDao();
	private InsertlistDao ildao = new InsertlistDao();
	
	public String login(String mid) {
		String result = null;
		Connection conn = getConnection();
		result = logindao.login(conn, mid);
		close(conn);
		return result;
	}
	
	public int insertList(InsertlistDto dto) {
		int result = 0;
		Connection conn = getConnection();
		result = ildao.insertList(conn, dto);
		close(conn);
		return result;
	}
}
