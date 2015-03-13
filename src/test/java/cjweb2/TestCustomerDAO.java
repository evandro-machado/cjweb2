package cjweb2;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.hightech.model.dao.CustomerDAO;
import br.com.hightech.model.entity.Customer;

public class TestCustomerDAO {

	//@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setName("Virmerson");
		customer.setPassword("123");
		customer.setEmail("virmerson@htcursos.com");
		
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.save(customer);
		
		//Assert.assertTrue(customer.getId()!=null);
		//Assert.assertNotNull(customer.getId());
	}
	
	//@Test
	public void testReadAll(){
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> customerList = customerDAO.readAll();
		assertTrue(customerList.size()>0);
	}
	
//	@Test
	public void testRemove(){
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.readById(2L);
		customerDAO.delete(customer);
		
	}
	
	@Test
	public void testReadById(){
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.readById(3L);
		assertTrue(customer!=null);
	}

}
