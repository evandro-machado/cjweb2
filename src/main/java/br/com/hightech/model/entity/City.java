package br.com.hightech.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class City {
	@Id
	@SequenceGenerator(name = "seq_cit", initialValue = 1)
	@GeneratedValue(generator = "seq_cit", strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@JoinColumn
	@ManyToOne
	private State state;

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
