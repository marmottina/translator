package index;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Kategorie extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 Integer kategoria = request.getParameter("kategoria") != null ? Integer.valueOf(request.getParameter("kategoria")) : null;
		 BazaDanych bazaDanych = new BazaDanych();
		 List<MojSlownik> listaMojSlownik = bazaDanych.slowaKategoria(kategoria);
		 request.setAttribute("listaMojSlownik", listaMojSlownik);
		 
		 getServletContext().getRequestDispatcher("/WEB-INF/view/kategorie.jsp").forward(request, response);
	 }
}

