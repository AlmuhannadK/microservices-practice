package com.almuhannad.departmentservice.controller;

import com.almuhannad.departmentservice.dto.DepartmentDto;
import com.almuhannad.departmentservice.service.DepartmentService;
import com.almuhannad.departmentservice.service.impl.DepartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/departments")
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentServiceImpl departmentService) {
		this.departmentService = departmentService;
	}
	
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto department) {
		
		return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List <DepartmentDto>> getAllDepartments() {
		
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}
	
	@GetMapping("/{department-code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
		return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
	}
}
