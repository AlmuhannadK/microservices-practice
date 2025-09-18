package com.almuhannad.employeeservice.dto;

import lombok.Builder;

@Builder
public record EmployeeDto(
		Long id,
		String firstName,
		String lastName,
		String email,
		String phoneNumber,
		String address) {
}
