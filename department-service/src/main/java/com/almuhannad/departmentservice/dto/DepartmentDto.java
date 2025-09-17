package com.almuhannad.departmentservice.dto;

import lombok.Builder;

@Builder
public record DepartmentDto(
		Long id,
		String departmentName,
		String departmentCode,
		String departmentDescription
) {
}
