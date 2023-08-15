package semi.dk.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.dk.member.model.dto.MemberDto;
import semi.dk.member.service.MemberService;

@WebServlet("/login.login")
public class LoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginDoController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Login");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		MemberDto loginvo = new MemberDto(mid, mpwd);
		String result = new MemberService().login(mid);
		String sendUrl = request.getContextPath();
		
		if(mpwd == null) {
			
		} else if(mpwd.equals(result)) { 
			System.out.println("로그인 성공");
			System.out.println(mid);
			request.setAttribute("loginId", mid);
			request.getSession().setAttribute("currentId", mid);
			sendUrl += "/user/main";
		} else {
			System.out.println("로그인 실패");
//			sendUrl = "/";
		}
		response.sendRedirect(sendUrl);
	}
	
}
