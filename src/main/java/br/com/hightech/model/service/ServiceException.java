package br.com.hightech.model.service;

import br.com.hightech.model.dao.DAOException;

public class ServiceException extends Exception {

	public ServiceException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public ServiceException(String message, DAOException e) {
		super(message,e);
	}

}
