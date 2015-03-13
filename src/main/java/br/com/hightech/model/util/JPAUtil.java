package br.com.hightech.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager em;
	
	static{
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
		em = entityManagerFactory.createEntityManager();
	}
	
	public static EntityManager openConection(){
		return em;
	}
	
}
