package com.almuhannad.departmentservice.mapper;

import com.almuhannad.departmentservice.dto.DepartmentDto;
import com.almuhannad.departmentservice.entity.Department;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
		componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {
	
	Department toEntity(DepartmentDto departmentDto);
	
	DepartmentDto toDto(Department department);
	
	// later use for partial update with PATCH
//	@BeanMapping(
//			nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//	Department partialUpdate(
//			DepartmentDto departmentDto, @MappingTarget Department department);
}