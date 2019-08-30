package br.com.JavaMaster.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.JavaMarter.util.JpaUtil;

public class GenericDAO<Entidade> {

	@SuppressWarnings("unused")
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {

		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		EntityManager em = JpaUtil.getInstance().getEm();

		try {

			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void excluir(Entidade entidade) {

		EntityManager em = JpaUtil.getInstance().getEm();
		try {

			em.getTransaction().begin();
			em.remove(entidade);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}
}