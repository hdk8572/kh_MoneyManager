package gagyebu.dk.list.model.service;

import static gagyebu.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.util.List;

import gagyebu.dk.list.model.dao.gagyebuListDao;
import gagyebu.dk.list.model.dto.gagyebuListDto;

public class gagyebuListService {

	gagyebuListDao dao = new gagyebuListDao(); 
	
	public List<gagyebuListDto> selectList() {
		List<gagyebuListDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
}
