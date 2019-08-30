package br.com.JavaMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.JavaMarter.util.JpaUtil;
import br.com.JavaMaster.entidade.Votacao;

public class VotacaoDAO extends GenericDAO<Votacao>{
	
	public List<Votacao> listar() {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Query consulta = em.createQuery("select votacao from Votacao votacao");
		@SuppressWarnings("unchecked")
		List<Votacao> votacao = consulta.getResultList();
		em.getTransaction().commit();
		return votacao;
	}

	public Votacao consultarPorId(Long id) {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Votacao votacao = em.find(Votacao.class, id);
		em.getTransaction().commit();
		return votacao;
	}

}
