package cjweb2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.hightech.model.dao.CustomerDAO;
import br.com.hightech.model.dao.DAOException;
import br.com.hightech.model.entity.Customer;

public class TestSpring {

	@Test
	public void testSpring() throws DAOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
		Customer customer = new Customer();
		customer.setName("Joãoaaa");
		customer.setEmail("joao@feijao.caom");
		customer.setPassword("feijao");
		
		customerDAO.save(customer);
	}

}
