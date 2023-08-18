package semi.dk.user.model.dao;

import static semi.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import semi.dk.user.model.dto.UserDto;

public class UserDao {
	// 리스트 조회 (** List)
	public List<UserDto> selectList(SqlSession session) {
		List<UserDto> result = null; 
		result = session.selectList("user1.selectList");
		return result;
	}
	// 리스트 추가 (** Insert)
	public int Insert(SqlSession session, UserDto dto) {
		int result = 0;
		result = session.insert("user1.insert", dto);
		return result;
	}
	
	// 리스트 검색
	public UserDto selectOne(Connection conn, String insertDate) {
		
		String query = "SELECT INSERT_DATE, MNO, MID, MPRICE, CATEGORY, CASHCARD, MNAME, DESCRIPTION FROM EX WHERE INSERT_DATE = ?";

		UserDto result = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, insertDate); 
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = new UserDto();
				result.setInsertDate(rs.getString("INSERT_DATE"));
				result.setMno(rs.getString("MNO"));
				result.setMid(rs.getString("MID"));
				result.setMprice(rs.getString("MPRICE"));
				result.setCategory(rs.getString("CATEGORY"));
				result.setCashCard(rs.getString("CASHCARD"));
				result.setMname(rs.getString("MNAME"));
				result.setDescription(rs.getString("DESCRIPTION"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}
	// 한 행 삭제
	public int delete(SqlSession session, String mno) {
		int result = 0;
		result = session.delete("user1.delete", mno);
		return result;
	}
}
