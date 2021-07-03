package com.spring.delitosmaps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.delitosmaps.dto.CrimeDTO;
import com.spring.delitosmaps.service.CrimeService;

@RestController
@RequestMapping(value = "/crimes")
public class CrimeController {

	@Autowired
	private CrimeService service;
	
	@GetMapping
	public ResponseEntity<List<CrimeDTO>> findAll() {
		List<CrimeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
