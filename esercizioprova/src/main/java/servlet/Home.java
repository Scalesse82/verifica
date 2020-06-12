package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DataBase;

@WebServlet(name = "home", urlPatterns = { "/","/home"})

public class Home extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase db = new DataBase((EntityManagerFactory) getServletContext().getAttribute("emf"));
        
		req.setAttribute("lista", db.mostraUtenti());
		req.getRequestDispatcher("pagina.jsp").forward(req, resp);
	}

}
