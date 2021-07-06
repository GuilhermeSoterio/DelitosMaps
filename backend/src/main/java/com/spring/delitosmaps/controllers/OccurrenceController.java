package com.spring.delitosmaps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.delitosmaps.dto.OccurrenceDTO;
import com.spring.delitosmaps.entities.Occurrence;
import com.spring.delitosmaps.service.OccurrenceService;

@RestController
@RequestMapping(value = "/occurrences")
public class OccurrenceController {

	@Autowired
	private OccurrenceService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Occurrence> findById(@PathVariable Long id) {
		Occurrence occurrence = service.findById(id);
		return ResponseEntity.ok().body(occurrence);
	}
	
	@GetMapping
	public ResponseEntity<List<OccurrenceDTO>> findAll() {
		List<OccurrenceDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<OccurrenceDTO> insert(@RequestBody OccurrenceDTO dto) {
		OccurrenceDTO newDTO = service.insert(dto);
		return ResponseEntity.ok().body(newDTO);

	}
}
