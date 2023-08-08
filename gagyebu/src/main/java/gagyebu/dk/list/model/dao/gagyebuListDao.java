package gagyebu.dk.list.model.dao;

import static gagyebu.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gagyebu.dk.list.model.dto.gagyebuListDto;

public class gagyebuListDao {

	public List<gagyebuListDto> selectList(Connection conn){
		
		String query = "SELECT INSERT_DATE, MNO, MID, MPRICE, CATEGORY, CASHCARD, MNAME, DESCRIPTION FROM EX";
		
		

		List<gagyebuListDto> result = new ArrayList<gagyebuListDto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			
			while(rs.next()==true) {
				gagyebuListDto dto = new gagyebuListDto();
				dto.setInsertDate(rs.getString("INSERT_DATE"));
				dto.setMno(rs.getString("MNO"));
				dto.setMid(rs.getString("MID"));
				dto.setMprice(rs.getString("MPRICE"));
				dto.setCategory(rs.getString("CATEGORY"));
				dto.setCashCard(rs.getString("CASHCARD"));
				dto.setMname(rs.getString("MNAME"));
				dto.setDescripion(rs.getString("DESCRIPTION"));
				
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

	public gagyebuListDto selectone(Connection conn, String insertDate){
		gagyebuListDto result = null;
		String query = "SELECT INSERT_DATE, MNO, MID, MPRICE, CATEGORY, CASHCARD, MNAME, DESCRIPTION FROM EX WHERE INSERT_DATE = ?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, insertDate);
			rs = stmt.executeQuery();
			
			while(rs.next() == true) {
//				gagyebuListDto sdto = new gagyebuListDto();
//				
//				sdto.setInsertDate(rs.getString("INSERT_DATE"));
//				sdto.setMno(rs.getString("MNO"));
//				sdto.setMid(rs.getString("MID"));
//				sdto.setMprice(rs.getString("MPRICE"));
//				sdto.setCategory(rs.getString("CATEGORY"));
//				sdto.setCashCard(rs.getString("CASHCARD"));
//				sdto.setMname(rs.getString("MNAME"));
//				sdto.setDescripion(rs.getString("DESCRIPTION"));
				
				
				result = new gagyebuListDto(rs.getString("INSERT_DATE"),
						rs.getString("MNO"),
						rs.getString("MID"),
						rs.getString("MPRICE"),
						rs.getString("CATEGORY"),
						rs.getString("CASHCARD"),
						rs.getString("MNAME"),
						rs.getString("DESCRIPTION"));
				
			}
			
			
//			if(rs.next()) {
//				result = new gagyebuListDto(rs.getString("INSERT_DATE"),
//						rs.getString("MNO"),
//						rs.getString("MID"),
//						rs.getString("MPRICE"),
//						rs.getString("CATEGORY"),
//						rs.getString("CASHCARD"),
//						rs.getString("MNAME"),
//						rs.getString("DESCRIPTION"));
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}
	

}

