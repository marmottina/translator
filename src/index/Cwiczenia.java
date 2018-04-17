package index;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Cwiczenia extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 Integer kategoria = request.getParameter("kategoria") != null ? Integer.valueOf(request.getParameter("kategoria")) : null;
		 BazaCwiczen bazaCwiczen = new BazaCwiczen();
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaCwiczen = bazaDanych.wylosujZdanie(kategoria);
		 request.setAttribute("bazaCwiczen", bazaCwiczen);
		 request.setAttribute("kategoria", request.getParameter("kategoria"));
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/cwiczenia.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}