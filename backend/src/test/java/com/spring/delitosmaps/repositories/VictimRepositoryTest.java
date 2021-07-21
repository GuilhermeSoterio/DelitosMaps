package com.spring.delitosmaps.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.delitosmaps.entities.Victim;

@DataJpaTest
@DisplayName("Tests for Victim Repository")
public class VictimRepositoryTest {
	@Autowired
	private VictimRepository victimRepository;
	
	@Test
	@DisplayName("Save creates victim when successful")
	void save_PersistVictim_WhenSuccessful() {
		Victim victimToBeSaved = createVictim();
		
		Victim victimSaved = this.victimRepository.save(victimToBeSaved);
		/*Verifica que o objeto não é nulo*/
		Assertions.assertThat(victimSaved).isNotNull();
		/*Verifica que o Id não é nulo*/
		Assertions.assertThat(victimSaved.getId()).isNotNull();
		/*VErifica se o nome do Victim é igual ao criado pela função "CreateVictim*/
		Assertions.assertThat(victimSaved.getGenre()).isEqualTo(victimToBeSaved.getGenre());
	}
	
	@Test
	@DisplayName("Save updates Victim when successful")
	void save_UpdatesVictim_WhenSuccessful() {
		Victim VictimToBeSaved = createVictim();
		
		Victim VictimSaved = this.victimRepository.save(VictimToBeSaved);
		
		VictimSaved.setGenre("female");
		
		Victim VictimUpdated = this.victimRepository.save(VictimSaved);
		
		/*Verifica que o objeto não é nulo*/
		Assertions.assertThat(VictimUpdated).isNotNull();
		/*Verifica que o Id não é nulo*/
		Assertions.assertThat(VictimUpdated.getId()).isNotNull();
		/*VErifica se o nome do Victim é igual ao criado pela função "CreateVictim*/
		Assertions.assertThat(VictimUpdated.getGenre()).isEqualTo(VictimSaved.getGenre());
	}
	
	@Test
	@DisplayName("Delete removes Victim when successful")
	void delete_RemovesVictim_WhenSuccessful() {
		Victim VictimToBeSaved = createVictim();
		
		Victim VictimSaved = this.victimRepository.save(VictimToBeSaved);
		
		this.victimRepository.delete(VictimSaved);
		
		Optional<Victim> VictimOptional = this.victimRepository.findById(VictimSaved.getId());
	
		Assertions.assertThat(VictimOptional).isEmpty();
	}
	
	private Victim createVictim() {
		Victim testevictim = new Victim((long) 7, "male", 23);
		return testevictim;
	}
	
	@Test
	@DisplayName("Find By Id Victim when successful")
	void findById_ReturnsListOfVictim_WhenSuccessful() {
		Victim VictimToBeSaved = createVictim();
		
		Victim VictimSaved = this.victimRepository.save(VictimToBeSaved);

		Long Id = VictimSaved.getId();
		
		Optional<Victim> Victims = this.victimRepository.findById(Id);
		
		Assertions.assertThat(Victims).isNotEmpty();
		Assertions.assertThat(Victims).contains(VictimSaved);
	}
	
	@Test
	@DisplayName("Find All Victim when successful")
	void findAll_ReturnsListOfVictim_WhenSuccessful() {
	
		List<Victim> Victims = this.victimRepository.findAll();
		
		Assertions.assertThat(Victims).isNotEmpty();
	}
	
	
	@Test
	@DisplayName("Find By Id returns empty list when no Victim is found")
	void findById_ReturnsEmptyList_WhenVictimIsNotFound() {
		Optional<Victim> Victims = this.victimRepository.findById((long) 521);
		
		Assertions.assertThat(Victims).isEmpty();
	}
}
