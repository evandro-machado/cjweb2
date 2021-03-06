package br.com.hightech.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.hightech.model.dao.CustomerDAO;
import br.com.hightech.model.dao.DAOException;
import br.com.hightech.model.entity.Customer;


@Service
public class CustomerService {
	
	@Inject
	private CustomerDAO customerDAO;
	
	public void save(Customer customer) throws ServiceException{

		try {
			//Business Rules validation
			if(customer.getName()==null || customer.getName()==""){
				throw new ServiceException("Customer's name can't be empty.");
			}
			customerDAO.save(customer);
		} catch (DAOException e) {
			throw new ServiceException("Not able to save customer.",e);
		}
	}
	
	public List<Customer> readAll(){
		List<Customer> list = customerDAO.readAll();
		return list;
	}

	public void remove(Customer customer) {
		customerDAO.delete(customer);
		
	}

}
