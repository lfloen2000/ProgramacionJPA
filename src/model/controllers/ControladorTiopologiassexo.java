package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Tipologiasexo;


public class ControladorTiopologiassexo {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroeducativoJPA");
	
private static ControladorTiopologiassexo instance = null;
	

	
	/**
	 * 
	 * @return
	 */
	public static ControladorTiopologiassexo getInstance () {
		if (instance == null) {
			instance = new ControladorTiopologiassexo();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorTiopologiassexo() {
		
	   

	}
	
	
	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findPrimero () {
		Tipologiasexo tip = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id limit 1", Tipologiasexo.class);
		tip = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return tip;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findUltimo () {
		Tipologiasexo tip = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id desc limit 1", Tipologiasexo.class);
		tip = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return tip;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findSiguiente (int idActual) {
		Tipologiasexo tip = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id > ? order by id limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		tip = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return tip;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findAnterior (int idActual) {
		Tipologiasexo tip = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id < ? order by id desc limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		tip = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return tip;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Tipologiasexo tip) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (tip.getId() == 0) {
				em.persist(tip);
			}
			else {
				em.merge(tip);
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

	@SuppressWarnings("unchecked")
	public List<Tipologiasexo> findAll() {
		List<Tipologiasexo> resultado = new ArrayList<Tipologiasexo>();
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT o FROM Tipologiasexo o", Tipologiasexo.class);
			resultado = (List<Tipologiasexo>) q.getResultList();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
		
	}
	
}
