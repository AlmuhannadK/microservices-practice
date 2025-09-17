package com.almuhannad.departmentservice.service;


import com.almuhannad.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto department);
	
	List <DepartmentDto> getAllDepartments();
	
	DepartmentDto getDepartmentByCode(String departmentCode);
}
