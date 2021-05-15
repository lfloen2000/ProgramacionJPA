package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;

public class ControladorMaterias {
	
EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroeducativoJPA");
	
	// instancia del singleton
	private static ControladorMaterias instancia = null;

	/**
	 * 
	 */
	public ControladorMaterias() {
	}

	/**
	 * 
	 * @return
	 */
	public static ControladorMaterias getInstancia() {
		if (instancia == null) {
			instancia = new ControladorMaterias();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Materia> findAll () {
		List<Materia> resultado = new ArrayList<Materia>();
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT o FROM Materia o", Materia.class);
			resultado = (List<Materia>) q.getResultList();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return resultado;
		}
	}

}
