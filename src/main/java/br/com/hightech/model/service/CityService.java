package br.com.hightech.model.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.hightech.model.dao.DAOException;
import br.com.hightech.model.dao.CityDAO;
import br.com.hightech.model.entity.Customer;
import br.com.hightech.model.entity.City;
import br.com.hightech.model.entity.State;

@Service
public class CityService {
	
	@Inject
	CityDAO cityDAO;
	
	public void save(City city) throws ServiceException{
		try {
			cityDAO.save(city);
		} catch (DAOException e) {
			throw new ServiceException("Not able to save.",e);
		}
	}
	
	public City readById(Long id){
		return cityDAO.readById(id);
	}
	
	public List<City> readAll(){
		List<City> list = cityDAO.readAll();
		return list;
	}

	public void remove(City city) {
		cityDAO.delete(city);
		
	}

	public List<City> readCities(State state) {
		// TODO Auto-generated method stub
		
		return cityDAO.readCities(state);
	}
	
}
