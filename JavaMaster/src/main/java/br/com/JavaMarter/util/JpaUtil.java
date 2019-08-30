package br.com.JavaMarter.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JpaUtil {
	
private EntityManager em;
	
    private static JpaUtil instance = null;
    
     
    public static JpaUtil getInstance(){
      if (instance == null){
         instance = new JpaUtil();
      }
       
      return instance;
    }
    
    private JpaUtil() {
    	
    	EntityManagerFactory emf = 
    		     Persistence.createEntityManagerFactory("JavaMaster");
    	
    	em = emf.createEntityManager();
    	
    }

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
    
   

}
