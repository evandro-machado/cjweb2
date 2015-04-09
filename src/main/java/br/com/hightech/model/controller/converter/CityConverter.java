package br.com.hightech.model.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hightech.model.entity.City;
import br.com.hightech.model.service.CityService;


@Named
public class CityConverter implements Converter{

	@Inject
	CityService cityService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String id) {
		// TODO Auto-generated method stub
		try{
			City city = cityService.readById(Long.parseLong(id));
			return city;
		}catch(NumberFormatException e){
			e.printStackTrace();
			return null;	
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object city) {
		// TODO Auto-generated method stub
		City c = (City) city;
		if(c.getId() == null) return null;
		return c.getId().toString();
	}

}
