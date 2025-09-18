package com.almuhannad.employeeservice.mapper;

import com.almuhannad.employeeservice.dto.EmployeeDto;
import com.almuhannad.employeeservice.entity.Employee;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
		componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
	
	Employee toEntity(EmployeeDto employeeDto);
	
	EmployeeDto toDto(Employee employee);
	
	// later use for partial updates with PATCH
//	@BeanMapping(
//			nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//	Employee partialUpdate(
//			EmployeeDto employeeDto, @MappingTarget Employee employee);
}