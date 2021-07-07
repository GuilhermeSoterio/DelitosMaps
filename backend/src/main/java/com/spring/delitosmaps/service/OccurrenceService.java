package com.spring.delitosmaps.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.delitosmaps.dto.OccurrenceDTO;
import com.spring.delitosmaps.dto.OccurrenceInsertDTO;
import com.spring.delitosmaps.entities.Crime;
import com.spring.delitosmaps.entities.Occurrence;
import com.spring.delitosmaps.entities.Victim;
import com.spring.delitosmaps.exceptions.ObjectNotFoundException;
import com.spring.delitosmaps.repositories.CrimeRepository;
import com.spring.delitosmaps.repositories.OccurrenceRepository;
import com.spring.delitosmaps.repositories.VictimRepository;

@Service
public class OccurrenceService {

	
	@Autowired
	private OccurrenceRepository repository;
	
	@Autowired
	private CrimeRepository crimeRepository;
	
	@Autowired
	private VictimRepository victimRepository;
	
	@Transactional(readOnly = true)
	public Occurrence findById(Long id) {
		Optional<Occurrence> occurrence = repository.findById(id);
		return occurrence.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Nome: "+ OccurrenceDTO.class.getName()));
	}
	
	
	@Transactional(readOnly = true)
	public List<OccurrenceDTO> findAll() {
		List<Occurrence> list = repository.findAll();
		return list.stream().map(x -> new OccurrenceDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public OccurrenceDTO insert(OccurrenceInsertDTO dto) {
		Occurrence entity = new Occurrence();
		
		entity.setLongitude(dto.getLongitude());
		entity.setLatitude(dto.getLatitude());
		entity.setDayOfTheWeek(dto.getDayOfTheWeek());
		entity.setDescription(dto.getDescription());
		entity.setFelonious_description(dto.getFelonious_description());
		entity.setMoment(Instant.now());
		entity.setAlone(dto.getAlone());
		entity.setDistrict(dto.getDistrict());
		

		Crime crime = crimeRepository.getById(dto.getCrimeID());
		entity.setCrime(crime);

		Victim victim = victimRepository.getOne(dto.getVictimID());
		entity.setVictim(victim);
		
		entity = repository.save(entity);
		return new OccurrenceDTO(entity);
	}


	@Transactional(readOnly = true)
	public Page<OccurrenceDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return repository.findByMoments(minDate, maxDate, pageRequest).map(x -> new OccurrenceDTO(x));
	}
}
