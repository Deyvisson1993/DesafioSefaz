package br.com.JavaMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.JavaMarter.util.JpaUtil;
import br.com.JavaMaster.entidade.Resposta;

public class RespostaDAO extends GenericDAO<Resposta> {

	public List<Resposta> listar() {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Query consulta = em.createQuery("select resposta from Resposta resposta");
		@SuppressWarnings("unchecked")
		List<Resposta> resposta = consulta.getResultList();
		em.getTransaction().commit();
		return resposta;
	}

	public Resposta consultarPorId(Long id) {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Resposta resposta = em.find(Resposta.class, id);
		em.getTransaction().commit();
		return resposta;
	}

}