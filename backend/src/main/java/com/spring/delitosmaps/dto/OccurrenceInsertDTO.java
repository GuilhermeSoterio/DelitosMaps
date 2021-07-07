package com.spring.delitosmaps.dto;

import java.io.Serializable;
import com.spring.delitosmaps.entities.enums.District;

public class OccurrenceInsertDTO implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private double longitude;
		private double latitude;
		private String dayOfTheWeek;
		private String description;
		private String felonious_description;
		private Boolean alone;
		private District district;
		
		private Long crimeID;
		private Long victimID;
		
		public OccurrenceInsertDTO() {
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
		
		public Boolean getAlone() {
			return alone;
		}
		public void setAlone(Boolean alone) {
			this.alone = alone;
		}
		
		public Long getCrimeID() {	
			return crimeID;
		}
		
		public void setCrimeID(Long crimeID) {
			this.crimeID = crimeID;
		}

		public Long getVictimID() {
			return victimID;
		}

		public void setVictimID(Long victimID) {
			this.victimID = victimID;
		}


		public District getDistrict() {
			return district;
		}

		public void setDistrict(District district) {
			this.district = district;
		}
		
}

		