package com.spring.delitosmaps.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_occurrence")
public class Occurrence implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double longitude;
	private double latitude;
	private String dayOfTheWeek;
	private String description;
	private String felonious_description;
	private Instant moment;
	private Boolean alone;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "crime_id")
	private Crime crime;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "victim_id")
	private Victim victim;
	
	public Occurrence() {
	}
	
	public Occurrence(Long id, Long longitude, Long latitude, String dayOfTheWeek, String description,
			String felonious_description, Instant moment, Boolean alone) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.dayOfTheWeek = dayOfTheWeek;
		this.description = description;
		this.felonious_description = felonious_description;
		this.moment = moment;
		this.alone = alone;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFelonious_description() {
		return felonious_description;
	}
	public void setFelonious_description(String felonious_description) {
		this.felonious_description = felonious_description;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public Boolean getAlone() {
		return alone;
	}
	
    public void setAlone(Boolean alone) {
		this.alone = alone;
	}

	public Crime getCrime() {
		return crime;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}
	
	public Victim getVictim() {
		return victim;
	}
	
	public void setVictim(Victim victim) {
		this.victim = victim;
	}
	
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
		Occurrence other = (Occurrence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
	
