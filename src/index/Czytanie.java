package index;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Czytanie extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 BazaCzytanie bazaCzytanie = new BazaCzytanie();
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaCzytanie= bazaDanych.wylosujCzytanie();
		 request.setAttribute("bazaCzytanie", bazaCzytanie);
		 
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/czytanie.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}