package semi.dk.user.model.dao;

import static semi.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.dk.user.model.dto.UserDto;

public class UserDao {
	// 리스트 조회 (** List)
	public List<UserDto> selectList(Connection conn) {
		
		String query = "SELECT INSERT_DATE, MNO, MID, MPRICE, CATEGORY, CASHCARD, MNAME, DESCRIPTION FROM EX ORDER BY MNO";

		List<UserDto> result = new ArrayList<UserDto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()==true) {
				UserDto dto = new UserDto();
				dto.setInsertDate(rs.getString("INSERT_DATE"));
				dto.setMno(rs.getString("MNO"));
				dto.setMid(rs.getString("MID"));
				dto.setMprice(rs.getString("MPRICE"));
				dto.setCategory(rs.getString("CATEGORY"));
				dto.setCashCard(rs.getString("CASHCARD"));
				dto.setMname(rs.getString("MNAME"));
				dto.setDescription(rs.getString("DESCRIPTION"));
				
				result.add(dto);
			}
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}
	// 리스트 추가 (** Insert)
	public int Insert(Connection conn, UserDto dto) {
		int result = 0;
		
		String query = "INSERT INTO EX VALUES (?, (SELECT COALESCE(MAX(mno), 0) + 1 FROM EX), ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(query);
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, dto.getInsertDate());
			stmt.setString(2, dto.getMid());
			stmt.setString(3, dto.getMprice());
			stmt.setString(4, dto.getCategory());
			stmt.setString(5, dto.getCashCard());
			stmt.setString(6, dto.getMname());
			stmt.setString(7, dto.getDescription());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
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
	public int delete(Connection conn, String mno) {
		
		int delete = 0;
		
		String query = "DELETE FROM EX WHERE MNO= ?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, mno);
			delete = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return delete;
	}
}
