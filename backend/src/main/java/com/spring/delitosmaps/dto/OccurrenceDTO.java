package com.spring.delitosmaps.dto;

import java.io.Serializable;
import java.time.Instant;


import com.spring.delitosmaps.entities.Occurrence;
import com.spring.delitosmaps.entities.enums.District;

public class OccurrenceDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private double longitude;
	private double latitude;
	private String dayOfTheWeek;
	private String description;
	private String felonious_description;
	private Instant moment;
	private Boolean alone;
	private String victimGenre;
	private int victimAge;
	private String crimeTypeName;
	private District district;

	
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	public OccurrenceDTO() {
	}
	
	public OccurrenceDTO(Occurrence entity) {
		id = entity.getId();
		longitude = entity.getLongitude();
		latitude = entity.getLatitude();
		dayOfTheWeek = entity.getDayOfTheWeek();
		description = entity.getDescription();
		felonious_description = entity.getFelonious_description();
		moment = entity.getMoment();
		alone = entity.getAlone();
		district = entity.getDistrict();/*
		victimGenre = entity.getVictim().getGenre();
		victimAge = entity.getVictim().getAge();
		crimeTypeName = entity.getCrime().getTypeCrime();
		*/
		setVictimAge(entity.getVictim().getAge());
		setVictimGenre(entity.getVictim().getGenre());
		setCrimeTypeName(entity.getCrime().getTypeCrime());
		
		//Gambiarra
		//setCrimeID(entity.getCrime().getId());
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

	public String getVictimGenre() {
		return victimGenre;
	}

	public void setVictimGenre(String victimGenre) {
		this.victimGenre = victimGenre;
	}

	public String getCrimeTypeName() {
		return crimeTypeName;
	}

	public void setCrimeTypeName(String crimeTypeName) {
		this.crimeTypeName = crimeTypeName;
	}
/*
	public Long getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(Long crimeId) {
		this.crimeId = crimeId;
	}

	public Long getVictimId() {
		return victimId;
	}

	public void setVictimId(Long victimId) {
		this.victimId = victimId;
	}
	*/

	public int getVictimAge() {
		return victimAge;
	}

	public void setVictimAge(int victimAge) {
		this.victimAge = victimAge;
	}
/*
	
	public Long getCrimeID() {	
		return crimeID;
	}

	public Long getVictimID() {
		return victimID;
	}

	public void setVictimID(Long victimID) {
		this.victimID = victimID;
	}

	public void setCrimeID(Long crimeID) {
		this.crimeID = crimeID;
	}*/
	


}
