package semi.dk.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.dk.user.model.dto.UserDto;
import semi.dk.user.model.service.UserService;

/**
 * Servlet implementation class AjaxDeleteController
 */
@WebServlet("/ajaxDelete")
public class AjaxDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxDeleteController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mno = request.getParameter("mno");

        int deletedList = new UserService().delete(mno);


        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(deletedList)); // Using Gson library for JSON conversion
        out.flush();
        out.close();
	}

}
