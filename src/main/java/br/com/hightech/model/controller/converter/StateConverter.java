package br.com.hightech.model.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hightech.model.entity.State;
import br.com.hightech.model.service.StateService;


@Named
public class StateConverter implements Converter{

	@Inject
	StateService stateService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object state) {
		// TODO Auto-generated method stub
		State s = (State) state;
		return s.getId().toString();
	}

}
