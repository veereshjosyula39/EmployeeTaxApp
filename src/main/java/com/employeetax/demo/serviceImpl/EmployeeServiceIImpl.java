package com.employeetax.demo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeetax.demo.dto.EmployeeDto;
import com.employeetax.demo.model.EmployeeModel;
import com.employeetax.demo.repository.EmployeeRepository;
import com.employeetax.demo.service.EmployeeService;

@Service
public class EmployeeServiceIImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto save(EmployeeDto employeeDto) {
		EmployeeModel  employeeModel = employeeRepository.save(new ModelMapper().map(employeeDto, EmployeeModel.class));
		EmployeeDto returnEmployeeDto = new ModelMapper().map(employeeModel, EmployeeDto.class);
		return returnEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployee(Long employeeID) {
		EmployeeModel  employeeModel = employeeRepository.findByEmployeeID(employeeID);
		EmployeeDto employeeDto = new ModelMapper().map(employeeModel, EmployeeDto.class);
		return employeeDto;
		
	}

}
