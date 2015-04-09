package br.com.hightech.model.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.hightech.model.dao.DAOException;
import br.com.hightech.model.dao.StateDAO;
import br.com.hightech.model.entity.Customer;
import br.com.hightech.model.entity.State;

@Service
public class StateService {
	
	@Inject
	StateDAO stateDAO;
	
	public void save(State state) throws ServiceException{
		try {
			stateDAO.save(state);
		} catch (DAOException e) {
			throw new ServiceException("Not able to save.",e);
		}
	}
	
	public State readById(Long id){
		return stateDAO.readById(id);
	}
	
	public List<State> readAll(){
		List<State> list = stateDAO.readAll();
		return list;
	}

	public void remove(State state) {
		stateDAO.delete(state);
		
	}
	
}
