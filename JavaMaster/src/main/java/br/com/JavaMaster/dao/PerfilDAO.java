package br.com.JavaMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.JavaMarter.util.JpaUtil;
import br.com.JavaMaster.entidade.Perfil;

public class PerfilDAO extends GenericDAO<Perfil> {
	
	public List<Perfil> listar() {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Query consulta = em.createQuery("select perfil from Perfil perfil");
		@SuppressWarnings("unchecked")
		List<Perfil> perfil = consulta.getResultList();
		em.getTransaction().commit();
		return perfil;
	}

	public Perfil consultarPorId(Long id) {
		
		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Perfil perfil = em.find(Perfil.class, id);
		em.getTransaction().commit();
		return perfil;
	}


}
