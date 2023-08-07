package gagyebu.dk.user.model.Dao;

import static gagyebu.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gagyebu.dk.user.model.Dto.gagyebuUserDto;

public class gagyebuUserDao {

	public List<gagyebuUserDto> selectList(Connection conn){
		
		String query = "SELECT INSERT_DATE, MNO, MID, MPRICE, CATEGORY, CASHCARD, MNAME, DESCRIPTION FROM EX";
		
		List<gagyebuUserDto> result = new ArrayList<gagyebuUserDto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			
			while(rs.next()==true) {
				gagyebuUserDto dto = new gagyebuUserDto();
				dto.setInsertDate(rs.getString("INSERT_DATE"));
				dto.setMno(rs.getInt("MNO"));
				dto.setMid(rs.getString("MID"));
				dto.setMprice(rs.getInt("MPRICE"));
				dto.setCategory(rs.getString("CATEGORY"));
				dto.setCashCard(rs.getString("CASHCARD"));
				dto.setMname(rs.getString("MNAME"));
				dto.setDescripion(rs.getString("DESCRIPTION"));
				
				result.add(dto);
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

