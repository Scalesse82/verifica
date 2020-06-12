package servlet;



import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelli.Utente;
import utility.DataBase;

@WebServlet(name = "aggiungiutente", urlPatterns = { "/aggiungiutente"})

public class AggiungiUtente extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/pagina.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		DataBase db = new DataBase((EntityManagerFactory) getServletContext().getAttribute("emf"));
		
		Utente u=new Utente();
		u.setNome(req.getParameter("nome"));
		u.setCognome(req.getParameter("cognome"));
		u.setNumero(Long.parseLong(req.getParameter("numero")));
		
		db.aggiungiUtente(u);
		req.setAttribute("lista", db.mostraUtenti());
		req.getRequestDispatcher("pagina.jsp").forward(req, resp);
	}

}
