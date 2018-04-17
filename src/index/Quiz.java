package index;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Quiz  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //Integer idquiz = request.getParameter("idquiz") != null ? Integer.valueOf(request.getParameter("idquiz")) : null;
		 BazaQuiz bazaQuiz = new BazaQuiz();
		 BazaDanych bazaDanych = new BazaDanych();
		 bazaQuiz = bazaDanych.wylosujQuiz();
		 request.setAttribute("bazaQuiz", bazaQuiz);
		 
		 
	        getServletContext().getRequestDispatcher("/WEB-INF/view/quiz.jsp").forward(request, response);
			 //request.getRequestDispatcher("/WEB-INF/view/welocme.jsp").forward(request, response);

	 }
}