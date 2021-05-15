package model.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Profesor;



public class ControladorProfesores {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroeducativoJPA");
	
	// instancia del singleton
	private static ControladorProfesores instancia = null;

	/**
	 * 
	 */
	public ControladorProfesores() {
	}

	/**
	 * 
	 * @return
	 */
	public static ControladorProfesores getInstancia() {
		if (instancia == null) {
			instancia = new ControladorProfesores();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Profesor> findAll () {
		List<Profesor> resultado = new ArrayList<Profesor>();
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT o FROM Profesor o", Profesor.class);
			resultado = (List<Profesor>) q.getResultList();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return resultado;		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Profesor findPrimero () {
		Profesor pro = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id limit 1", Profesor.class);
		pro = (Profesor) q.getSingleResult();
		em.close();
		
		return pro;
	}
	

	/**
	 * 
	 * @return
	 */
	public Profesor findUltimo () {
		Profesor pro = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id desc limit 1", Profesor.class);
		pro = (Profesor) q.getSingleResult();
		em.close();
		
		return pro;
	}
	

	/**
	 * 
	 * @return
	 */
	public Profesor findSiguiente (int idActual) {
		Profesor pro = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id > ? order by id limit 1", Profesor.class);
		q.setParameter(1, idActual);
		pro = (Profesor) q.getSingleResult();
		em.close();
		
		return pro;
	}
	

	/**
	 * 
	 * @return
	 */
	public Profesor findAnterior (int idActual) {
		Profesor pro = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id < ? order by id desc limit 1", Profesor.class);
		q.setParameter(1, idActual);
		pro = (Profesor) q.getSingleResult();
		em.close();
		
		return pro;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Profesor pro) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (pro.getId() == 0) {
				em.persist(pro);
			}
			else {
				em.merge(pro);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

}
