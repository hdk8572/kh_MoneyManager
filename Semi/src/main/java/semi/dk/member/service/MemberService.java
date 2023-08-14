package semi.dk.member.service;

import static semi.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.util.List;

import semi.dk.member.model.dao.MemberDao;
import semi.dk.member.model.dto.MemberDto;
import semi.dk.user.model.dto.UserDto;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
	public String login(String mid) {
		String result = null;
		Connection conn = getConnection();
		result = dao.login(conn, mid);
		close(conn);
		return result;
	}
	
	public int join(MemberDto mid) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.join(conn, mid);
		close(conn);
		return result;
	}
}
