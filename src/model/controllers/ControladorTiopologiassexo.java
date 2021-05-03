package model.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Tipologiasexo;


public class ControladorTiopologiassexo {

private static ControladorTiopologiassexo instance = null;
public Connection conn = null;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroeducativoJPA");
	
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

	public List<Tipologiasexo> findAll() {
		List<Tipologiasexo> tipos = new ArrayList<Tipologiasexo>();
		try {
			Statement s = this.conn.createStatement();
			ResultSet rs =  s.executeQuery("select * from centroeducativo.Tipologiasexo");
			while (rs.next()) {
				Tipologiasexo tip = new Tipologiasexo();
				tip.setId(rs.getInt("id"));
				tip.setDescripcion(rs.getString("descripcion"));
				
				// Agrego el fabricante a la lista
				tipos.add(tip);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return tipos;
		
	}
	
}
