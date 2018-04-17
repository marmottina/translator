package index;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Mapy extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 BazaMapy bazaMapy = new BazaMapy();
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaMapy = bazaDanych.wylosujMapy();
		 request.setAttribute("bazaMapy", bazaMapy);
		 
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/mapy.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}