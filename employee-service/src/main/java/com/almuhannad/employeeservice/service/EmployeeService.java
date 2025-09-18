package com.almuhannad.employeeservice.service;

import com.almuhannad.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	
	EmployeeDto saveEmployee(EmployeeDto employee);
	
	EmployeeDto getEmployeeById(Long id);
}
