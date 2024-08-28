package com.devsuperior.aula.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.service.PersonService;

@RestController
@RequestMapping(value = "/people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody PersonDepartmentDTO personDepartmentDTO) {
		personDepartmentDTO = personService.insert(personDepartmentDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(personDepartmentDTO.id())
				.toUri();
		return ResponseEntity.created(uri).body(personDepartmentDTO);
	}
	
	@PostMapping
	public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO personDTO) {
		personDTO = personService.insert(personDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(personDTO.id())
				.toUri();
		return ResponseEntity.created(uri).body(personDTO);
	}

}
