package cjweb2;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.hightech.model.dao.DAOException;
import br.com.hightech.model.dao.StateDAO;
import br.com.hightech.model.entity.State;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestStateDAO {

	@Inject
	StateDAO stateDAO;
	
	@Test
	public void testSave() throws DAOException{
		State s = new State();
		s.setName("MS");
		
		stateDAO.save(s);
	}
	
}
