package br.com.hightech.model.controller.bean;

import java.util.List;





import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.hightech.model.entity.City;
import br.com.hightech.model.entity.State;
import br.com.hightech.model.service.CityService;
import br.com.hightech.model.service.ServiceException;

@Controller
@ViewScoped
public class CityBean {
	private City city = new City();

	@Inject
	private CityService cityService;
	
	private List<City> cityList;
	
	@PostConstruct
	public void init(){
		//cityList = cityService.readAll();
	}
	
	
	public void readCities(ValueChangeEvent event){
		
		if(event.getNewValue() != event.getOldValue()){

			State state = (State) event.getNewValue();
			cityList = cityService.readCities(state);
		}
	}
	
	public CityService getCityService() {
		return cityService;
	}



	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}



	public void save(){
		try {
			cityService.save(city);
			//Clean city data
			city = new City();
			System.out.println("salvou");
			
			//Update List
			cityList = cityService.readAll();
			
			//Success Message
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successfully Signed Up", null));
			
			
			
		} catch (ServiceException e) {
			// Print error message code on screen
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Save error: "+e.getMessage(), null));
			
		}
	}
	
	public void remove(){
		cityService.remove(city);
		//Clean form
		city = new City();
		//Update List
		cityList = cityService.readAll();
	}
	
	
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}



	public List<City> getCityList() {
		return cityList;
	}



	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	

}
