package com.almuhannad.departmentservice.service.impl;

import com.almuhannad.departmentservice.dto.DepartmentDto;
import com.almuhannad.departmentservice.entity.Department;
import com.almuhannad.departmentservice.repository.DepartmentRepository;
import com.almuhannad.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		
		this.departmentRepository = departmentRepository;
	}
	
	
	public DepartmentDto saveDepartment(DepartmentDto department) {
		
		Department newDepartment = new Department(
				department.id(),
				department.departmentName(),
				department.departmentCode(),
				department.departmentDescription()
		);
		
		Department savedDepartment = departmentRepository.save(newDepartment);
		
		log.info("Saved Department with code {}", savedDepartment.getDepartmentCode());
		
		return DepartmentDto.builder()
				.id(savedDepartment.getId())
				.departmentName(savedDepartment.getDepartmentName())
				.departmentCode(savedDepartment.getDepartmentCode())
				.departmentDescription(savedDepartment.getDepartmentDescription())
				.build();
	}
	
	public List <DepartmentDto> getAllDepartments() {
		
		List <Department> allDepartments = departmentRepository.findAll();
		
		log.info("Returning all {} departments", allDepartments.size());
		
		return allDepartments.stream()
				.map(department -> {
					return DepartmentDto.builder()
							.id(department.getId())
							.departmentName(department.getDepartmentName())
							.departmentCode(department.getDepartmentCode())
							.departmentDescription(department.getDepartmentDescription())
							.build();
				})
				.toList();
	}
	
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		log.info("Returning Department {}", department.getDepartmentName());
		
		return DepartmentDto.builder()
				.id(department.getId())
				.departmentName(department.getDepartmentName())
				.departmentCode(department.getDepartmentCode())
				.departmentDescription(department.getDepartmentDescription())
				.build();
	}
}
