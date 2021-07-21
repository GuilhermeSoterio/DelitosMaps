package com.spring.delitosmaps.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.delitosmaps.entities.Occurrence;

@DataJpaTest
@DisplayName("Tests for Occurrence Repository")
public class OccurrenceRepositoryTest {
	@Autowired
	private OccurrenceRepository OccurrenceRepository;
	
	@Test
	@DisplayName("Save creates Occurrence when successful")
	void save_PersistOccurrence_WhenSuccessful() {
		Occurrence OccurrenceToBeSaved = createOccurrence();
		
		Occurrence OccurrenceSaved = this.OccurrenceRepository.save(OccurrenceToBeSaved);
		/*Verifica que o objeto não é nulo*/
		Assertions.assertThat(OccurrenceSaved).isNotNull();
		/*Verifica que o Id não é nulo*/
		Assertions.assertThat(OccurrenceSaved.getId()).isNotNull();
		/*VErifica se o nome do Occurrence é igual ao criado pela função "CreateOccurrence*/
		Assertions.assertThat(OccurrenceSaved.getDescription()).isEqualTo(OccurrenceToBeSaved.getDescription());
	}
	
	@Test
	@DisplayName("Save updates Occurrence when successful")
	void save_UpdatesOccurrence_WhenSuccessful() {
		Occurrence OccurrenceToBeSaved = createOccurrence();
		
		Occurrence OccurrenceSaved = this.OccurrenceRepository.save(OccurrenceToBeSaved);
		
		OccurrenceSaved.setDescription("test test test");
		
		Occurrence OccurrenceUpdated = this.OccurrenceRepository.save(OccurrenceSaved);
		
		/*Verifica que o objeto não é nulo*/
		Assertions.assertThat(OccurrenceUpdated).isNotNull();
		/*Verifica que o Id não é nulo*/
		Assertions.assertThat(OccurrenceUpdated.getId()).isNotNull();
		/*VErifica se o nome do Occurrence é igual ao criado pela função "CreateOccurrence*/
		Assertions.assertThat(OccurrenceUpdated.getDescription()).isEqualTo(OccurrenceSaved.getDescription());
	}
	
	@Test
	@DisplayName("Delete removes Occurrence when successful")
	void delete_RemovesOccurrence_WhenSuccessful() {
		Occurrence OccurrenceToBeSaved = createOccurrence();
		
		Occurrence OccurrenceSaved = this.OccurrenceRepository.save(OccurrenceToBeSaved);
		
		this.OccurrenceRepository.delete(OccurrenceSaved);
		
		Optional<Occurrence> OccurrenceOptional = this.OccurrenceRepository.findById(OccurrenceSaved.getId());
	
		Assertions.assertThat(OccurrenceOptional).isEmpty();
	}
	
	private Occurrence createOccurrence() {
		Occurrence testeOccurrence = new Occurrence();
		testeOccurrence.setId((long)11);
		testeOccurrence.setDescription("Real test");
		return testeOccurrence;
	}
	
	@Test
	@DisplayName("Find By Id Occurrence when successful")
	void findById_ReturnsListOfOccurrence_WhenSuccessful() {
		Occurrence OccurrenceToBeSaved = createOccurrence();
		
		Occurrence OccurrenceSaved = this.OccurrenceRepository.save(OccurrenceToBeSaved);

		Long Id = OccurrenceSaved.getId();
		
		Optional<Occurrence> Occurrences = this.OccurrenceRepository.findById(Id);
		
		Assertions.assertThat(Occurrences).isNotEmpty();
		Assertions.assertThat(Occurrences).contains(OccurrenceSaved);
	}
	
	@Test
	@DisplayName("Find All Occurrence when successful")
	void findAll_ReturnsListOfOccurrence_WhenSuccessful() {
	
		List<Occurrence> Occurrences = this.OccurrenceRepository.findAll();
		
		Assertions.assertThat(Occurrences).isNotEmpty();
	}
	
	
	@Test
	@DisplayName("Find By Id returns empty list when no Occurrence is found")
	void findById_ReturnsEmptyList_WhenOccurrenceIsNotFound() {
		Optional<Occurrence> Occurrences = this.OccurrenceRepository.findById((long) 521);
		
		Assertions.assertThat(Occurrences).isEmpty();
	}
}