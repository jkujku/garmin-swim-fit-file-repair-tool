package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 462069270850827125L;

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "Hello World!";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		response.getWriter().write(result);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

}