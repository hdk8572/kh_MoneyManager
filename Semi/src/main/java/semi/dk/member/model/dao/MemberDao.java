package semi.dk.member.model.dao;

import static semi.dk.common.DkTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.dk.member.model.dto.MemberDto;
import semi.dk.user.model.dto.UserDto;

public class MemberDao {

	public String login(Connection conn, String mid) {
		
		String result = null;
		String query = "SELECT MID, MPWD, MNAME, MEMAIL FROM EX_MEMBER WHERE MID=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, mid);
			rs = stmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("mpwd");
				System.out.println("비밀번호 확인 완료!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}
	
	public int join(Connection conn, MemberDto vo) {
		int result = 0;
		String query = "INSERT INTO EX_MEMBER VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpwd());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMemail());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
