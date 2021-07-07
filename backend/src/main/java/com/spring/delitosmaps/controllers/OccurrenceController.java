package com.spring.delitosmaps.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.delitosmaps.dto.OccurrenceDTO;
import com.spring.delitosmaps.dto.OccurrenceInsertDTO;
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
	
	
	@GetMapping(value = "pages")
	public ResponseEntity<Page<OccurrenceDTO>> findAll(
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {

	Instant minDate = ("".equals(min)) ? null : Instant.parse(min); // Converte a data para string
	Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

	if(linesPerPage == 0) {
		linesPerPage = Integer.MAX_VALUE;
	}
	
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
	
	Page<OccurrenceDTO> list = service.findByMoments(minDate, maxDate, pageRequest);
	return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<OccurrenceDTO> insert(@RequestBody OccurrenceInsertDTO dto) {
		OccurrenceDTO newDTO = service.insert(dto);
		return ResponseEntity.ok().body(newDTO);

	}
}
