package model.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Profesor;


public class ControladorProfesores {
	
private static ControladorProfesores instance = null;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroeducativoJPA");
	
	/**
	 * 
	 * @return
	 */
	public static ControladorProfesores getInstance () {
		if (instance == null) {
			instance = new ControladorProfesores();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorProfesores() {
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/centroeducativo?serverTimezone=UTC","educacion", "1234");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		   

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
