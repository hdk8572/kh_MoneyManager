package gagyebu.dk.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gagyebu.dk.common.DkService;
import gagyebu.dk.member.dto.LoginDto;
import gagyebu.dk.member.model.dao.LoginDao;

@WebServlet("/login.login")
public class LoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginDoController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		System.out.println(mid);
		System.out.println(mpwd);
		LoginDto log = new LoginDto(mid, mpwd);  
		String result = new DkService().login(mid);
		String sendUrl = request.getContextPath();
		
		if(mpwd == null) {
			System.out.println("계정 없음");
		} else if (mpwd.equals(result)){
			System.out.println("로그인 성공");
			request.setAttribute("loginId", mid);
			sendUrl += "/user/list"; 
		} else {
			System.out.println("로그인 실패");
			request.setAttribute("loginId", mid);
			sendUrl += "/"; 
		}
		response.sendRedirect(sendUrl);
	}

}
