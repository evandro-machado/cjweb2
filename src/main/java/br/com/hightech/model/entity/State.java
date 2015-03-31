package br.com.hightech.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class State {
	@Id
	@SequenceGenerator( name = "seq_sta", initialValue = 1)
	@GeneratedValue( generator = "seq_sta", strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY )
	List<City> cities;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}