package com.devsuperior.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public PersonDepartmentDTO insert(PersonDepartmentDTO personDepartmentDTO) {
		Person person = personDepartmentDTO.toEntity();
		Department department = departmentRepository.getReferenceById(personDepartmentDTO.department().id());
		person.setDepartment(department);
		person = personRepository.save(person);
		return new PersonDepartmentDTO(person);
	}

}
