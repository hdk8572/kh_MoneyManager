//package gagyebu.dk.insertlist.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import gagyebu.dk.common.DkService;
//import gagyebu.dk.insertlist.model.Dto.InsertlistDto;
//
///**
// * Servlet implementation class Insertlistcontroller
// */
//@WebServlet("/user/list.do")
//public class InsertlistDocontroller extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private DkService service = new DkService();
//	
//
//    public InsertlistDocontroller() {
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String mnoStr = request.getParameter("mno");
//		String mpriceStr = request.getParameter("mprice");
//		
//		int mno = 0;
//		int mprice = 0;
//		
//		mno = Integer.parseInt(mnoStr);
//		mprice = Integer.parseInt(mpriceStr);
//		
//		
//		String insertDate = request.getParameter("insertDate");
////		String mno = request.getParameter("mno");
//		String mid = request.getParameter("mid");
////		String mprice = request.getParameter("mprice");
//		String category = request.getParameter("category");
//		String cashCard = request.getParameter("cashCard");
//		String mname = request.getParameter("mname");
//		String descripion = request.getParameter("descripion");
//		
//		InsertlistDto idto = new InsertlistDto(insertDate, mno, mid, mprice, category, cashCard, mname, descripion);
//		
//		int result = service.insertList(idto);
//		System.out.println(result);
//		
//	}
//
//}
