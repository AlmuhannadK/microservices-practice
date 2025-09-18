package com.almuhannad.employeeservice.service.impl;

import com.almuhannad.employeeservice.dto.EmployeeDto;
import com.almuhannad.employeeservice.entity.Employee;
import com.almuhannad.employeeservice.repository.EmployeeRepository;
import com.almuhannad.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeDto saveEmployee(EmployeeDto employee) {
		
		Employee newEmployee = new Employee(
				employee.id(),
				employee.firstName(),
				employee.lastName(),
				employee.email(),
				employee.phoneNumber(),
				employee.address()
		);
		
		Employee savedEmployee = employeeRepository.save(newEmployee);
		
		log.info("Created employee with id {}", savedEmployee.getId());
		
		return EmployeeDto.builder()
				.id(savedEmployee.getId())
				.firstName(savedEmployee.getFirstName())
				.lastName(savedEmployee.getLastName())
				.phoneNumber(savedEmployee.getPhoneNumber())
				.email(savedEmployee.getEmail())
				.address(savedEmployee.getAddress())
				.build();
	}
	
	
	public EmployeeDto getEmployeeById(Long id) {
		
		Employee employee = employeeRepository.findEmployeeById(id);
		
		log.info("Found employee with id {}", employee.getId());
		return EmployeeDto.builder()
				.id(employee.getId())
				.firstName(employee.getFirstName())
				.lastName(employee.getLastName())
				.phoneNumber(employee.getPhoneNumber())
				.email(employee.getEmail())
				.address(employee.getAddress())
				.build();
	}
}
