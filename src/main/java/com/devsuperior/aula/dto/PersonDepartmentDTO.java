package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Person;

public record PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
	
	public PersonDepartmentDTO(Person person) {
		this(person.getId(), person.getName(), person.getSalary(), new DepartmentDTO(person.getDepartment()));
	}

	public Person toEntity() {
		return new Person(id, name, salary, department.toEntity());
	}
	
}
