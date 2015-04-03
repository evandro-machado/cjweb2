package br.com.hightech.model.controller.bean;

import java.util.List;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
	
	private List<Customer> customerList;
	
	@PostConstruct
	public void init(){
		customerList = customerService.readAll();
	}
	
	
	public CustomerService getCustomerService() {
		return customerService;
	}



	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}



	public void save(){
		try {
			customerService.save(customer);
			//Clean customer data
			customer = new Customer();
			System.out.println("salvou");
			
			//Update List
			customerList = customerService.readAll();
			
			//Success Message
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successfully Signed Up", null));
			
			
			
		} catch (CustomerServiceException e) {
			// Print error message code on screen
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Save error: "+e.getMessage(), null));
			
		}
	}
	
	public void remove(){
		customerService.remove(customer);
		//Clean form
		customer = new Customer();
		//Update List
		customerList = customerService.readAll();
	}
	
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public List<Customer> getCustomerList() {
		return customerList;
	}



	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	

}
