package cjweb2;

import javax.persistence.EntityManager;

import br.com.hightech.model.entity.Customer;
import br.com.hightech.model.util.JPAUtil;

public class JPAUtilTest {
	public static void main(String[] args) {
		//Instance of Entity Manager
		EntityManager em = JPAUtil.openConection();
		
		//Object to be persisted
		Customer customer = new Customer();
		
		customer.setName("Bruno");
		customer.setEmail("bruno@sella.com");
		customer.setPassword("aoaoaoa");
		
		
		//Open transaction
		em.getTransaction().begin(); 
		em.persist(customer);
		//Commit transaction
		em.getTransaction().commit();
		
		
	}
}
