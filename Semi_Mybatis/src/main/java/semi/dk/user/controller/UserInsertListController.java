package semi.dk.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.dk.user.model.dto.UserDto;
import semi.dk.user.model.service.UserService;

@WebServlet("/user/main.main")
public class UserInsertListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private UserService service = new UserService();
	
    public UserInsertListController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 지출 등록 (** Insert)
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String insertDate = request.getParameter("insertDate");
		String mno = request.getParameter("mno");
		String mid = request.getParameter("mid");
//		String mid = requset.getSession().getA
		String mprice = request.getParameter("mprice");
		String category = request.getParameter("category");
		String cashCard = request.getParameter("cashCard");
		String mname = request.getParameter("mname");
		String description = request.getParameter("description");
		
		UserDto idto = new UserDto(insertDate, mno, mid, mprice, category, cashCard, mname, description);
		
		int result = service.InsertGetList(idto);
		System.out.println(result);
		if(result == 0) {  // 오류발생
//			request.getSession().setAttribute("msg", mname+"학생 등록에 실패했습니다. 정보를 다시 확인하고 등록해주세요.");
			response.sendRedirect(request.getContextPath()+"/user/main");	
		} else {  // 등록 성공
//			request.getSession().setAttribute("msg", mname+"학생 등록 되었습니다.");
			response.sendRedirect(request.getContextPath()+"/user/main");		
		}
	}

}
