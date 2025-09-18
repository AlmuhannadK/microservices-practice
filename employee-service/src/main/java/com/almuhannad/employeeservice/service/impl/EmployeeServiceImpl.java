package com.almuhannad.employeeservice.service.impl;

import com.almuhannad.employeeservice.dto.EmployeeDto;
import com.almuhannad.employeeservice.entity.Employee;
import com.almuhannad.employeeservice.mapper.EmployeeMapper;
import com.almuhannad.employeeservice.repository.EmployeeRepository;
import com.almuhannad.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	private final EmployeeMapper employeeMapper;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}
	
	public EmployeeDto saveEmployee(EmployeeDto employee) {
		
		Employee newEmployee = employeeMapper.toEntity(employee);
		
		Employee savedEmployee = employeeRepository.save(newEmployee);
		
		log.info("Created employee with id {}", savedEmployee.getId());
		
		return employeeMapper.toDto(savedEmployee);
	}
	
	
	public EmployeeDto getEmployeeById(Long id) {
		
		Employee employee = employeeRepository.findEmployeeById(id);
		
		log.info("Found employee with id {}", employee.getId());
		
		return employeeMapper.toDto(employee);
	}
}
