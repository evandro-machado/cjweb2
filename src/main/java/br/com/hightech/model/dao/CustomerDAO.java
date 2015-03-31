package br.com.hightech.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hightech.model.entity.Customer;
import br.com.hightech.model.util.JPAUtil;
@Repository
public class CustomerDAO {
	
//	Entity Manager Dependency injection
	@PersistenceContext
	EntityManager em;
	
	public CustomerDAO(){
//		 em = JPAUtil.openConection();
	}
	
	@Transactional
	public void save(Customer customer) throws CustomerDAOException{
		try{
			em.merge(customer);
		}catch (Exception e){
			throw new CustomerDAOException("Not able to save customer.",e);
		}
	}
		
	public void delete(Customer customer){
		em.getTransaction().begin();
		em.remove(customer);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> readAll(){
		Query hql = em.createQuery("select c from Customer c");
		return hql.getResultList();		
	}
	
	public Customer readById(Long id){
		return em.find(Customer.class, id);
	}
}
