package cjweb2;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.hightech.model.dao.CustomerDAO;
import br.com.hightech.model.dao.DAOException;
import br.com.hightech.model.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCustomerDAO {
	
	@Inject
	CustomerDAO customerDAO;

	@Test
	public void testSave() throws DAOException {
		Customer customer = new Customer();
		customer.setName("Nova");
		customer.setPassword("Teste");
		customer.setEmail("cindy@teste.com");
		
		customerDAO.save(customer);
		
		//Assert.assertTrue(customer.getId()!=null);
		//Assert.assertNotNull(customer.getId());
	}
	
//	@Test
	public void testReadAll(){
		List<Customer> customerList = customerDAO.readAll();
		assertTrue(customerList.size()>0);
	}
	
//	@Test
	public void testRemove(){
		Customer customer = customerDAO.readById(2L);
		customerDAO.delete(customer);
		
	}
	
//	@Test
	public void testReadById(){
		Customer customer = customerDAO.readById(3L);
		assertTrue(customer!=null);
	}

}
