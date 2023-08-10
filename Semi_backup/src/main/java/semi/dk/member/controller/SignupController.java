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

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		request.getRequestDispatcher("/WEB-INF/user/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");

		BufferedReader br = request.getReader();
		String signData = br.readLine();
		System.out.println(signData);
//		여러줄 읽지 않아도 됨. 1줄만 읽으면 됨.
//		while( (reqData = br.readLine()) != null) {
//		}
		
		Gson gson = new Gson();
		MemberDto[] memberArray = gson.fromJson(signData, MemberDto[].class);
		List<MemberDto> memberList = Arrays.asList(memberArray);
		System.out.println(memberList);
		
		for(MemberDto vo : memberList) {
			System.out.println(vo.getMid());
		}
	}

}
