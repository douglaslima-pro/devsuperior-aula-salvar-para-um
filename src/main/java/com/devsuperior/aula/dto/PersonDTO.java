package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;

public record PersonDTO(Long id, String name, Double salary, Long departmentId) {
	
	public PersonDTO(Person person) {
		this(person.getId(), person.getName(), person.getSalary(), person.getDepartment().getId());
	}

	public Person toEntity() {
		return new Person(id, name, salary, new Department(departmentId, null));
	}
	
}
