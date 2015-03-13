package br.com.hightech.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hightech.model.entity.Customer;
import br.com.hightech.model.util.JPAUtil;

public class CustomerDAO {
	EntityManager em;
	
	public CustomerDAO(){
		em = JPAUtil.openConection();
	}
	
	public void save(Customer customer){
		try{
			em.getTransaction().begin();
			em.merge(customer);
			em.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
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
