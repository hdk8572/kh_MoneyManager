package semi.dk.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.dk.user.model.dto.UserDto;
import semi.dk.user.model.service.UserService;

@WebServlet("/main.ajaxlist")
public class AjaxPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxPageController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}