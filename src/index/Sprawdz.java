package index;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sprawdz extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter(); 
		 
		 getServletContext().getRequestDispatcher("/WEB-INF/view/sprawdz.jsp").forward(request, response);
		 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}
