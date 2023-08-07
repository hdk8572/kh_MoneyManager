package gagyebu.dk.member.model.service;

import static gagyebu.dk.common.DkTemplate.*;

import java.sql.Connection;

import gagyebu.dk.member.model.dao.LoginDao;

public class LoginService {

	private LoginDao dao = new LoginDao();
	
	public String login(String mid) {
		String result = null;
		Connection conn = getConnection();
		result = dao.login(conn, mid);
		close(conn);
		return result;
	}
}
