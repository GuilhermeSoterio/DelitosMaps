package com.spring.delitosmaps.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.delitosmaps.entities.Crime;

@DataJpaTest
@DisplayName("Tests for crime Repository")
public class CrimeRepositoryTest {
	@Autowired
	private CrimeRepository crimeRepository;
	
	@Test
	@DisplayName("Save creates crime when successful")
	void save_PersistCrime_WhenSuccessful() {
		Crime crimeToBeSaved = createCrime();
		
		Crime crimeSaved = this.crimeRepository.save(crimeToBeSaved);
		/*Verifica que o objeto não é nulo*/
		Assertions.assertThat(crimeSaved).isNotNull();
		/*Verifica que o Id não é nulo*/
		Assertions.assertThat(crimeSaved.getId()).isNotNull();
		/*VErifica se o nome do crime é igual ao criado pela função "CreateCrime*/
		Assertions.assertThat(crimeSaved.getTypeCrime()).isEqualTo(crimeToBeSaved.getTypeCrime());
	}
	
	@Test
	@DisplayName("Save updates crime when successful")
	void save_UpdatesCrime_WhenSuccessful() {
		Crime crimeToBeSaved = createCrime();
		
		Crime crimeSaved = this.crimeRepository.save(crimeToBeSaved);
		
		crimeSaved.setTypeCrime("Atentado ao pudor");
		
		Crime crimeUpdated = this.crimeRepository.save(crimeSaved);
		
		/*Verifica que o objeto não é nulo*/
		Assertions.assertThat(crimeUpdated).isNotNull();
		/*Verifica que o Id não é nulo*/
		Assertions.assertThat(crimeUpdated.getId()).isNotNull();
		/*VErifica se o nome do crime é igual ao criado pela função "CreateCrime*/
		Assertions.assertThat(crimeUpdated.getTypeCrime()).isEqualTo(crimeSaved.getTypeCrime());
	}
	
	@Test
	@DisplayName("Delete removes crime when successful")
	void delete_RemovesCrime_WhenSuccessful() {
		Crime crimeToBeSaved = createCrime();
		
		Crime crimeSaved = this.crimeRepository.save(crimeToBeSaved);
		
		this.crimeRepository.delete(crimeSaved);
		
		Optional<Crime> crimeOptional = this.crimeRepository.findById(crimeSaved.getId());
	
		Assertions.assertThat(crimeOptional).isEmpty();
	}
	
	private Crime createCrime() {
		Crime testecrime = new Crime((long) 7, "depreciação");
		return testecrime;
	}
	
	@Test
	@DisplayName("Find By Id crime when successful")
	void findById_ReturnsListOfCrime_WhenSuccessful() {
		Crime crimeToBeSaved = createCrime();
		
		Crime crimeSaved = this.crimeRepository.save(crimeToBeSaved);

		Long Id = crimeSaved.getId();
		
		Optional<Crime> crimes = this.crimeRepository.findById(Id);
		
		Assertions.assertThat(crimes).isNotEmpty();
		Assertions.assertThat(crimes).contains(crimeSaved);
	}
	
	@Test
	@DisplayName("Find All crime when successful")
	void findAll_ReturnsListOfCrime_WhenSuccessful() {
	
		List<Crime> crimes = this.crimeRepository.findAll();
		
		Assertions.assertThat(crimes).isNotEmpty();
	}
	
	
	@Test
	@DisplayName("Find By Id returns empty list when no crime is found")
	void findById_ReturnsEmptyList_WhenCrimeIsNotFound() {
		Optional<Crime> crimes = this.crimeRepository.findById((long) 521);
		
		Assertions.assertThat(crimes).isEmpty();
	}
}
