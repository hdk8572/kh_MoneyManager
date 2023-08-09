package semi.dk.login.model.dao;

import static semi.dk.common.DkTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}
}
