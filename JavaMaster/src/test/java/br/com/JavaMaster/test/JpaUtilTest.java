package br.com.JavaMaster.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.JavaMarter.util.JpaUtil;

public class JpaUtilTest {
	
	@Test
	public void conectar() {
		
		EntityManager em = JpaUtil.getInstance().getEm();
		em.close();
		
	}

}
