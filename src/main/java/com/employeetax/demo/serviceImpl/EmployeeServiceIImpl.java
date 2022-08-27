package com.employeetax.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeetax.demo.dto.EmployeeDto;
import com.employeetax.demo.model.EmployeeModel;
import com.employeetax.demo.repository.EmployeeRepository;
import com.employeetax.demo.service.EmployeeService;

import net.bytebuddy.description.type.TypeVariableToken;

@Service
public class EmployeeServiceIImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto save(EmployeeDto employeeDto) {
		EmployeeModel employeeModel = employeeRepository.save(new ModelMapper().map(employeeDto, EmployeeModel.class));
		EmployeeDto returnEmployeeDto = new ModelMapper().map(employeeModel, EmployeeDto.class);
		returnEmployeeDto.setPhoneNumber(
				Stream.of(employeeModel.getPhoneNumber().replaceAll("\\[", "").replaceAll("\\]", "").split(",", -1))
						.collect(Collectors.toList()));
		return returnEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployee(Long employeeID) {
		EmployeeModel employeeModel = employeeRepository.findByEmployeeID(employeeID);
		EmployeeDto employeeDto = new ModelMapper().map(employeeModel, EmployeeDto.class);
		return employeeDto;

	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<EmployeeModel> employees = employeeRepository.findAll();
		List<EmployeeDto> employeesDto = new ArrayList<>();
		employees.stream().forEach(employee -> {
			EmployeeDto employeeDto = new ModelMapper().map(employee, new TypeToken<EmployeeDto>() {
			}.getType());
			employeesDto.add(employeeDto);
		});
		return employeesDto;
	}

}
