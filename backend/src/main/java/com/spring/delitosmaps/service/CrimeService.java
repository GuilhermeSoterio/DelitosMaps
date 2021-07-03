package com.spring.delitosmaps.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.delitosmaps.dto.CrimeDTO;
import com.spring.delitosmaps.entities.Crime;
import com.spring.delitosmaps.repositories.CrimeRepository;

@Service
public class CrimeService {

	@Autowired
	private CrimeRepository repository;
	
	//Operação de busca no banco de dados. Por isso o read Only. Evita um lock no banco de dados.
	@Transactional(readOnly = true)
	public List<CrimeDTO> findAll() {
		List<Crime> list = repository.findAll();
		return list.stream().map(x -> new CrimeDTO(x)).collect(Collectors.toList());
	}
/*	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		List<Game> list = repository.findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}*/
}
