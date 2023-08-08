package gagyebu.dk.list.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gagyebu.dk.common.DkService;
import gagyebu.dk.insertlist.model.Dto.InsertlistDto;
import gagyebu.dk.list.model.dto.gagyebuListDto;
import gagyebu.dk.list.model.service.gagyebuListService;


/**
 * Servlet implementation class gagyebuList
 */
@WebServlet("/user/list")
public class gagyebuListList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	gagyebuListService service = new gagyebuListService();
	private DkService iservice = new DkService();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<gagyebuListDto> gagyebuList = service.selectList();
		request.setAttribute("gagyebuList", gagyebuList);
		
		request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 지출 등록
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String insertDate = request.getParameter("insertDate");
		String mno = request.getParameter("mno");
		String mid = request.getParameter("mid");
		String mprice = request.getParameter("mprice");
		String category = request.getParameter("category");
		String cashCard = request.getParameter("cashCard");
		String mname = request.getParameter("mname");
		String descripion = request.getParameter("descripion");
		
		InsertlistDto idto = new InsertlistDto(insertDate, mno, mid, mprice, category, cashCard, mname, descripion);
		
		int result = iservice.insertList(idto);
		System.out.println(result);
		if(result < 1) {  // 오류발생
			request.getSession().setAttribute("msg", mname+"학생 등록에 실패했습니다. 정보를 다시 확인하고 등록해주세요.");
			response.sendRedirect(request.getContextPath()+"/user/list");	
		} else {  // 등록 성공
			request.getSession().setAttribute("msg", mname+"학생 등록 되었습니다.");
			response.sendRedirect(request.getContextPath()+"/user/list");		
		}
	}

}
