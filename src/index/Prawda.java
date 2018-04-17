package index;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Prawda extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //Integer idquiz = request.getParameter("idquiz") != null ? Integer.valueOf(request.getParameter("idquiz")) : null;
		 BazaPrawda bazaPrawda = new BazaPrawda();
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaPrawda = bazaDanych.wylosujPrawda();
		 request.setAttribute("bazaPrawda", bazaPrawda);
		 
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/prawda.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}