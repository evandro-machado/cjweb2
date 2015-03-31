package br.com.hightech.model.service;

import br.com.hightech.model.dao.CustomerDAOException;

public class CustomerServiceException extends Exception {

	public CustomerServiceException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public CustomerServiceException(String message, CustomerDAOException e) {
		super(message,e);
	}

}
