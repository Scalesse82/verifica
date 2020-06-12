package utility;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import modelli.Utente;


public class DataBase {
	
	
	private EntityManager em;

	public DataBase(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}

	public Utente aggiungiUtente(Utente utente) {
		em.getTransaction().begin();
		em.persist(utente);
		em.getTransaction().commit();
		return utente;
	}
	
	public List<Utente> mostraUtenti() {
		return em.createQuery("SELECT utente FROM Utente utente", Utente.class).getResultList();
	}
	
	

}
