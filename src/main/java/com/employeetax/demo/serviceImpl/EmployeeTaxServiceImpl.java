package com.employeetax.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.employeetax.demo.dto.EmployeeDto;
import com.employeetax.demo.dto.EmployeeTaxDto;
import com.employeetax.demo.service.EmployeeService;
import com.employeetax.demo.service.EmployeeServiceTaxService;
import com.employeetax.demo.util.TaxUtil;

public class EmployeeTaxServiceImpl implements EmployeeServiceTaxService {

	@Autowired
	EmployeeService employeeService;
	
	@Override
	public EmployeeTaxDto getEmployeeTax(Long employeeID) {
		
		EmployeeDto employeeDto = employeeService.getEmployee(employeeID);
		
		EmployeeTaxDto employeeTaxDto = new EmployeeTaxDto();
		employeeTaxDto.setEmployeeID(employeeID);
		employeeTaxDto.setFirstName(employeeDto.getFirstName());
		employeeTaxDto.setLastName(employeeDto.getLastName());
		employeeTaxDto.setSalaryYearly(TaxUtil.getTotalSalary(employeeDto.getDoj(), employeeDto.getSalary()));
		employeeTaxDto.setTaxAmount(TaxUtil.getTax(employeeTaxDto.getSalaryYearly()));
		employeeTaxDto.setCessAmount(employeeTaxDto.getSalaryYearly());
		return employeeTaxDto;
		
	}

}
