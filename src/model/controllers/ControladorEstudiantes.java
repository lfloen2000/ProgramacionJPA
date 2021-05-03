package model.controllers;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;


public class ControladorEstudiantes {
	public Connection conn = null;
	
private static ControladorEstudiantes instance = null;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroeducativoJPA");
	
	/**
	 * 
	 * @return
	 */
	public static ControladorEstudiantes getInstance () {
		if (instance == null) {
			instance = new ControladorEstudiantes();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorEstudiantes() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/centroeducativo?serverTimezone=UTC","educacion", "1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		   

	}
	
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findPrimero () {
		Estudiante est = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id limit 1", Estudiante.class);
		est = (Estudiante) q.getSingleResult();
		em.close();
		
		return est;
	}
	

	/**
	 * 
	 * @return
	 */
	public Estudiante findUltimo () {
		Estudiante est = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id desc limit 1", Estudiante.class);
		est = (Estudiante) q.getSingleResult();
		em.close();
		
		return est;
	}
	

	/**
	 * 
	 * @return
	 */
	public Estudiante findSiguiente (int idActual) {
		Estudiante est = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id > ? order by id limit 1", Estudiante.class);
		q.setParameter(1, idActual);
		est = (Estudiante) q.getSingleResult();
		em.close();
		
		return est;
	}
	

	/**
	 * 
	 * @return
	 */
	public Estudiante findAnterior (int idActual) {
		Estudiante est = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id < ? order by id desc limit 1", Estudiante.class);
		q.setParameter(1, idActual);
		est = (Estudiante) q.getSingleResult();
		em.close();
		
		return est;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar(Estudiante est) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (est.getId() == 0) {
				em.persist(est);
			}
			else {
				em.merge(est);
			}
			em.getTransaction().commit();
			em.close();
//			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
