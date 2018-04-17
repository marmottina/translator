package index;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Gramatyka extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 Integer kategoria = request.getParameter("kategoria") != null ? Integer.valueOf(request.getParameter("kategoria")) : null;
		 BazaGramatyka bazaGramatyka = new BazaGramatyka();
		 BazaDanych bazaDanych = new BazaDanych();
		 List<BazaGramatyka> listaBazaGramatyka = bazaDanych.Gramatyka(kategoria);
		 request.setAttribute("listaBazaGramatyka", listaBazaGramatyka);
		 request.setAttribute("kategoria", request.getParameter("kategoria"));
	        getServletContext().getRequestDispatcher("/WEB-INF/view/gramatyka.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}