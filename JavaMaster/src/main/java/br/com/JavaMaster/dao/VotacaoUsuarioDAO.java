package br.com.JavaMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.JavaMarter.util.JpaUtil;
import br.com.JavaMaster.entidade.VotacaoUsuario;

public class VotacaoUsuarioDAO extends GenericDAO<VotacaoUsuario>{
	
	public List<VotacaoUsuario> listar() {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Query consulta = em.createQuery("select votacaoUsuario from VotacaoUsuario votacaoUsuario");
		@SuppressWarnings("unchecked")
		List<VotacaoUsuario> votacao = consulta.getResultList();
		em.getTransaction().commit();
		return votacao;
	}

	public VotacaoUsuario consultarPorId(Long id) {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		VotacaoUsuario votacao = em.find(VotacaoUsuario.class, id);
		em.getTransaction().commit();
		return votacao;
	}

}
