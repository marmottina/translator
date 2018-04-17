package index;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Wybor extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BazaWybor bazaWybor = new BazaWybor();
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaWybor = bazaDanych.wylosujWybor();
		 request.setAttribute("bazaWybor", bazaWybor);
		 
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/wybor.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}