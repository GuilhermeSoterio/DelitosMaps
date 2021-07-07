package com.spring.delitosmaps.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_crime")
public class Crime implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String typeCrime;
	

	@OneToMany(mappedBy = "crime")
	private List<Occurrence> occurrences = new ArrayList<>();
	
	public Crime() {
	}

	public Crime(Long id, String typeCrime) {
		this.id = id;
		this.typeCrime = typeCrime;
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
/*
	public List<Occurrence> getOcurrences() {
		return occurrences;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
