package br.com.JavaMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.JavaMarter.util.JpaUtil;
import br.com.JavaMaster.entidade.Curso;

public class CursoDAO extends GenericDAO<Curso> {

	public List<Curso> listar() {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Query consulta = em.createQuery("select curso from Curso curso");
		@SuppressWarnings("unchecked")
		List<Curso> curso = consulta.getResultList();
		em.getTransaction().commit();
		return curso;
	}

	public Curso consultarPorId(Long id) {
		
		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Curso curso = em.find(Curso.class, id);
		em.getTransaction().commit();
		return curso;
	}

}
