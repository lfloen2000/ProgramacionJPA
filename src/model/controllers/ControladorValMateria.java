package model.controllers;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.ValoracionMateria;

public class ControladorValMateria {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroeducativoJPA");
		
		// instancia del singleton
		private static ControladorValMateria instancia = null;

		/**
		 * 
		 */
		public ControladorValMateria() {
		}

		/**
		 * 
		 * @return
		 */
		public static ControladorValMateria getInstancia() {
			if (instancia == null) {
				instancia = new ControladorValMateria();
			}
			return instancia;
		}

		/**
		 * 
		 * @return
		 */
		public ValoracionMateria findByMateriaAndProfesorAndEstudiante (Materia m, Profesor p, Estudiante e) {
			ValoracionMateria resultado = null;
			try {
				EntityManager em = this.factory.createEntityManager();
				Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idMateria = ? and "
						+ "idProfesor = ? and idEstudiante = ?", ValoracionMateria.class);
				q.setParameter(1, m.getId());
				q.setParameter(2, p.getId());
				q.setParameter(3, e.getId());
				resultado = (ValoracionMateria) q.getSingleResult();
				em.close();
			}
			catch (NoResultException nrEx) {
			}
			return resultado;
		}
		
		
		/**
		 * 
		 * @param e
		 */
		public boolean save(ValoracionMateria e) {
			EntityManager em = this.factory.createEntityManager();
			try {
				em.getTransaction().begin();
				if (e.getId() != 0) {
					em.merge(e);
				}
				else {
					em.persist(e);
				}
				em.getTransaction().commit();
			}
			catch (Exception ex) {
				ex.printStackTrace();
				em.getTransaction().rollback();
				return false;
			}
			return true;
		}
	
	
	

	
	
}
