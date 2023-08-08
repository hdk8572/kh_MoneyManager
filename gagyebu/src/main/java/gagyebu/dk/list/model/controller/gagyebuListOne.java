package gagyebu.dk.list.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gagyebu.dk.list.model.dto.gagyebuListDto;
import gagyebu.dk.list.model.service.gagyebuListService;

@WebServlet("/selectDate")
public class gagyebuListOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private gagyebuListService service = new gagyebuListService();   
	
    public gagyebuListOne() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String searchInsertDate = request.getParameter("searchInsertDate");
				System.out.println(searchInsertDate);
				
				gagyebuListDto searchResult = service.selectOne(searchInsertDate); 
				System.out.println(searchResult);
				
				if(searchResult!=null) {
					request.setAttribute("sdate", searchResult);
					request.getRequestDispatcher("/WEB-INF/views/user/get.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request, response);
				}
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

}
