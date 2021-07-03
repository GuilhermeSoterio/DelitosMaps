package com.spring.delitosmaps.dto;

import java.io.Serializable;

import com.spring.delitosmaps.entities.Crime;

public class CrimeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String typeCrime;
	
	public CrimeDTO() {
	}
	
	//Recebe a entidade como argumento/parâmetro
	public CrimeDTO(Crime entity) {
		id = entity.getId();
		typeCrime = entity.getTypeCrime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeCrime() {
		return typeCrime;
	}

	public void setTypeCrime(String typeCrime) {
		this.typeCrime = typeCrime;
	}
	
}
