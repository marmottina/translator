package index;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tlumaczenie extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 //String polskieSlowo = request.getParameter("polskieSlowo");
		 //String wloskieSlowo = request.getParameter("wloskieSlowo");
		 //SingletonNoweSlowa.aggiungiMojSlownik(polskieSlowo, wloskieSlowo);
		 MojSlownik mojSlownik = new MojSlownik();
		 BazaDanych bazaDanych = new BazaDanych();
		 mojSlownik = bazaDanych.wylosujSlowo(null);
		 request.setAttribute("mojSlowniki", mojSlownik);
		 request.setAttribute("lang", request.getParameter("lang"));
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/tlumaczenie.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }

}
