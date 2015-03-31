package br.com.hightech.model.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hightech.model.dao.CustomerDAO;
import br.com.hightech.model.dao.CustomerDAOException;
import br.com.hightech.model.entity.Customer;


@Service
public class CustomerService {
	
	@Inject
	private CustomerDAO customerDAO;
	
	public void save(Customer customer) throws CustomerServiceException{
		//Business Rules validation
		if(customer.getName()==null){
			throw new CustomerServiceException("Customer's name can't be empty.");
		}
		try {
			customerDAO.save(customer);
		} catch (CustomerDAOException e) {
			throw new CustomerServiceException("Not able to save customer.",e);
		}
	}

}
