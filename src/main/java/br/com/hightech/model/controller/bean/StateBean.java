package br.com.hightech.model.controller.bean;

import java.util.List;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.hightech.model.entity.State;
import br.com.hightech.model.service.StateService;
import br.com.hightech.model.service.ServiceException;

@Controller
@ViewScoped
public class StateBean {
	private State state = new State();

	@Inject
	private StateService stateService;
	
	private List<State> stateList;
	
	@PostConstruct
	public void init(){
		stateList = stateService.readAll();
	}
	
	
	public StateService getStateService() {
		return stateService;
	}



	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}



	public void save(){
		try {
			stateService.save(state);
			//Clean state data
			state = new State();
			System.out.println("salvou");
			
			//Update List
			stateList = stateService.readAll();
			
			//Success Message
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successfully Signed Up", null));
			
			
			
		} catch (ServiceException e) {
			// Print error message code on screen
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Save error: "+e.getMessage(), null));
			
		}
	}
	
	public void remove(){
		stateService.remove(state);
		//Clean form
		state = new State();
		//Update List
		stateList = stateService.readAll();
	}
	
	
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}



	public List<State> getStateList() {
		return stateList;
	}



	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}
	

}
