package semi.dk.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.dk.user.model.dto.UserDto;
import semi.dk.user.model.service.UserService;

@WebServlet("/ajaxSearch")
public class AjaxSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service = new UserService();
	
    public AjaxSearchController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String searchDate = request.getParameter("searchDate");
		System.out.println("searchDate :"+searchDate);
		UserDto dvo = service.selectOne(searchDate);
		request.setAttribute("dvo", dvo);
	}

}
