package br.com.JavaMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.JavaMarter.util.JpaUtil;
import br.com.JavaMaster.entidade.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public List<Usuario> listar() {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Query consulta = em.createQuery("select usuario from Usuario usuario");
		@SuppressWarnings("unchecked")
		List<Usuario> usuario = consulta.getResultList();
		em.getTransaction().commit();
		return usuario;
	}

	public Usuario consultarPorId(Long id) {
		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, id);
		em.getTransaction().commit();
		return usuario;
	}

}
