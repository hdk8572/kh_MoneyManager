package semi.dk.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.dk.member.model.dto.MemberDto;
import semi.dk.member.service.MemberService;
import semi.dk.user.model.dto.UserDto;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService service = new MemberService();
	
    public SignupController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		request.getRequestDispatcher("/WEB-INF/member/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDto ivo = new MemberDto(mid, mpwd, mname, memail);
		System.out.println("ivo :" + ivo);
		int result = service.join(ivo);	
		System.out.println("result :" + result);
        if (result == 0) {
			/* response.sendRedirect(request.getContextPath() + "/success.jsp"); */
        	System.out.println("회원가입 성공");
        } else {
			/* response.sendRedirect(request.getContextPath() + "/error.jsp"); */
        	System.out.println("회원가입 실패");
        }
		
        request.getRequestDispatcher("/").forward(request, response);
        		
        
	}
}
