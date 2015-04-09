package cjweb2;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.hightech.model.dao.CityDAO;
import br.com.hightech.model.dao.DAOException;
import br.com.hightech.model.dao.StateDAO;
import br.com.hightech.model.entity.City;
import br.com.hightech.model.entity.State;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCityDAO {

	@Inject
	CityDAO cityDAO;
	
	@Inject
	StateDAO stateDAO;
	
	@Test
	public void testSave() throws DAOException{
		State state = stateDAO.readById(77L);
		
		City city = new City();
		city.setName("Campinas");
		city.setState(state);
		
		cityDAO.save(city);
	}
	
}
