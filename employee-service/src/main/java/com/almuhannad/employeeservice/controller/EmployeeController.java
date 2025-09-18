package com.almuhannad.employeeservice.controller;

import com.almuhannad.employeeservice.dto.EmployeeDto;
import com.almuhannad.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity <EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		
		return new ResponseEntity<>(employeeService.saveEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("employee-id") Long employeeId) {
		
		return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
	}
	


}
