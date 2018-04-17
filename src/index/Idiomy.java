package index;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Idiomy extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 BazaIdiomy bazaIdiomy = new BazaIdiomy();
		 BazaDanych bazaDanych = new BazaDanych();
		 List<BazaIdiomy> listaBazaIdiomy = bazaDanych.Idiomy();
		 request.setAttribute("listaBazaIdiomy", listaBazaIdiomy);
		 
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/idiomy.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}