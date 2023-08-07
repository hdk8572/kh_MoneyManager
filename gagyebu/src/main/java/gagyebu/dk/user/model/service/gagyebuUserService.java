package gagyebu.dk.user.model.service;

import static gagyebu.dk.common.DkTemplate.*;

import java.sql.Connection;
import java.util.List;

import gagyebu.dk.user.model.Dao.gagyebuUserDao;
import gagyebu.dk.user.model.Dto.gagyebuUserDto;

public class gagyebuUserService {

	gagyebuUserDao dao = new gagyebuUserDao(); 
	
	public List<gagyebuUserDto> selectList() {
		List<gagyebuUserDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
}
