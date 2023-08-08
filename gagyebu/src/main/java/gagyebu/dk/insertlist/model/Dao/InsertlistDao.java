package gagyebu.dk.insertlist.model.Dao;

import static gagyebu.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gagyebu.dk.insertlist.model.Dto.InsertlistDto;

public class InsertlistDao {

	public int insertList(Connection conn, InsertlistDto dto) {
		int result = 0;
		
//		String query = "INSERT INTO EX VALUES (20230727, SEQ_EX.NEXTVAL, 'kh0001', '5100', '留덊듃/�렪�쓽�젏', '泥댄겕移대뱶', '�븘蹂댁뭅�룄諛붾굹�굹伊ъ뒪', NULL)";
		String query = "INSERT INTO EX VALUES (?, (SELECT COALESCE(MAX(mno), 0) + 1 FROM EX), ?, ?, ?, ?, ?, ?)";
//		String query = "INSERT INTO EX VALUES (?, SEQ_EX.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = null;
		try {
//			stmt = conn.prepareStatement(query);
//			stmt.setString(1, dto.getInsertDate());
//			stmt.setInt(2, dto.getMno());
//			stmt.setString(3, dto.getMid());
//			stmt.setInt(4, dto.getMprice());
//			stmt.setString(5, dto.getCategory());
//			stmt.setString(6, dto.getCashCard());
//			stmt.setString(7, dto.getMname());
//			stmt.setString(8, dto.getDescripion());
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, dto.getInsertDate());
			stmt.setString(2, dto.getMid());
			stmt.setString(3, dto.getMprice());
			stmt.setString(4, dto.getCategory());
			stmt.setString(5, dto.getCashCard());
			stmt.setString(6, dto.getMname());
			stmt.setString(7, dto.getDescripion());
			
			result = stmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}
}
