package semi.dk.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.dk.user.model.dao.UserDao;
import semi.dk.user.model.dto.UserDto;
import semi.dk.user.model.service.UserService;

/**
 * Servlet implementation class UserListController
 */
@WebServlet("/user/main")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserService service = new UserService();  
	
    public UserListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserDto> ulist = service.selectList();
		request.setAttribute("ulist", ulist);
		
		request.getRequestDispatcher("/WEB-INF/user/main.jsp").forward(request, response);
//		request.getRequestDispatcher("/WEB-INF/user/sticky_test.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}