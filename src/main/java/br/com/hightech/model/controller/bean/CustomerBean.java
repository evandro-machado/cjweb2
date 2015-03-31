package br.com.hightech.model.controller.bean;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.hightech.model.entity.Customer;
import br.com.hightech.model.service.CustomerService;
import br.com.hightech.model.service.CustomerServiceException;

@Controller
@ViewScoped
public class CustomerBean {
	private Customer customer = new Customer();

	@Inject
	private CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}



	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}



	public void save(){
		try {
			customerService.save(customer);
		} catch (CustomerServiceException e) {
			// Print error message code on screen
			e.printStackTrace();
		}
	};
	
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
