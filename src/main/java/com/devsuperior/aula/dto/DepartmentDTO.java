package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Department;

public record DepartmentDTO(Long id, String name) {
	
	public DepartmentDTO(Department department) {
		this(department.getId(), department.getName());
	}

	public Department toEntity() {
		return new Department(id, name);
	}

}
