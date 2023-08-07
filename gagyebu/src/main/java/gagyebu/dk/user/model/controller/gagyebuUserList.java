package gagyebu.dk.user.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gagyebu.dk.user.model.Dto.gagyebuUserDto;
import gagyebu.dk.user.model.service.gagyebuUserService;

/**
 * Servlet implementation class gagyebuList
 */
@WebServlet("/user/list")
public class gagyebuUserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	gagyebuUserService service = new gagyebuUserService();
	
    public gagyebuUserList() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<gagyebuUserDto> gagyebuList = service.selectList();
		request.setAttribute("gagyebuList", gagyebuList);
		
		request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
