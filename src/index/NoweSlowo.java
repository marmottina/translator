package index;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class NoweSlowo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 execute(request, response);
		 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);
 
	 }
	 
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String polskieSlowo = request.getParameter("polskieSlowo");
		 String wloskieSlowo = request.getParameter("wloskieSlowo");
		 Integer kategoria = request.getParameter("kategoria") != null ? Integer.valueOf(request.getParameter("kategoria")) : null;
		 //SingletonNoweSlowa.aggiungiMojSlownik(polskieSlowo, wloskieSlowo);
		 MojSlownik mojSlownik = new MojSlownik(polskieSlowo, wloskieSlowo, kategoria);
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaDanych.dopiszDoTabeli(mojSlownik);
		 execute(request, response);
	}
	 
	 private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //request.setAttribute("mojSlowniki", SingletonNoweSlowa .leggiMojSlowniki());
		 getServletContext().getRequestDispatcher("/WEB-INF/view/noweSlowo.jsp").forward(request, response);
	 }

}
