package br.com.JavaMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.JavaMarter.util.JpaUtil;
import br.com.JavaMaster.entidade.Pergunta;

public class PerguntaDAO extends GenericDAO<Pergunta>{
	
	public List<Pergunta> listar() {

		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Query consulta = em.createQuery("select pergunta from Pergunta pergunta");
		@SuppressWarnings("unchecked")
		List<Pergunta> pergunta = consulta.getResultList();
		em.getTransaction().commit();
		return pergunta;
	}

	public Pergunta consultarPorId(Long id) {
		EntityManager em = JpaUtil.getInstance().getEm();

		em.getTransaction().begin();
		Pergunta pergunta = em.find(Pergunta.class, id);
		em.getTransaction().commit();
		return pergunta;
	}


}
