package com.almuhannad.departmentservice.service.impl;

import com.almuhannad.departmentservice.dto.DepartmentDto;
import com.almuhannad.departmentservice.entity.Department;
import com.almuhannad.departmentservice.mapper.DepartmentMapper;
import com.almuhannad.departmentservice.repository.DepartmentRepository;
import com.almuhannad.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	
	private final DepartmentMapper departmentMapper;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
		
		this.departmentRepository = departmentRepository;
		this.departmentMapper = departmentMapper;
	}
	
	
	public DepartmentDto saveDepartment(DepartmentDto department) {
		
		Department newDepartment = departmentMapper.toEntity(department);
		
		Department savedDepartment = departmentRepository.save(newDepartment);
		
		log.info("Saved Department with code {}", savedDepartment.getDepartmentCode());
		
		return departmentMapper.toDto(savedDepartment);
	}
	
	public List <DepartmentDto> getAllDepartments() {
		
		List <Department> allDepartments = departmentRepository.findAll();
		
		log.info("Returning all {} departments", allDepartments.size());
		
		return allDepartments.stream()
				.map(departmentMapper::toDto)
				.toList();
	}
	
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		log.info("Returning Department {}", department.getDepartmentName());
		
		return departmentMapper.toDto(department);
	}
}
