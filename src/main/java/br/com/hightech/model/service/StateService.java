package br.com.hightech.model.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.hightech.model.dao.StateDAO;

@Service
public class StateService {
	
	@Inject
	StateDAO stateDAO;
	
	
}
