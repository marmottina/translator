package index;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Teksty extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 BazaTeksty bazaTeksty = new BazaTeksty();
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaTeksty = bazaDanych.wylosujTeksty();
		 request.setAttribute("bazaTeksty", bazaTeksty);
		 
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/teksty.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}