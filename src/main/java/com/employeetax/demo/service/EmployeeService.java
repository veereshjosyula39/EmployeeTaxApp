package com.employeetax.demo.service;

import com.employeetax.demo.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto save(EmployeeDto employeeDto);
	public EmployeeDto getEmployee(Long employeeID);
}
