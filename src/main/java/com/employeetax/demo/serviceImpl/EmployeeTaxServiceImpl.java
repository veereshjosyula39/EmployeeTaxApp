package com.employeetax.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

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
	public List<EmployeeTaxDto> getEmployeesTax() {
		
		List<EmployeeDto> employeesDto = employeeService.getAllEmployee();
		List<EmployeeTaxDto> employeesTaxDto = new ArrayList<EmployeeTaxDto>();
		for(EmployeeDto employeeDto : employeesDto) {
			EmployeeTaxDto employeeTaxDto = getEmployeeTax(employeeDto);
			employeesTaxDto.add(employeeTaxDto);
		}
		return employeesTaxDto;
		
	}
	
	public EmployeeTaxDto getEmployeeTax(EmployeeDto employeeDto) {
		EmployeeTaxDto employeeTaxDto = new EmployeeTaxDto();
		employeeTaxDto.setEmployeeID(employeeDto.getEmployeeID());
		employeeTaxDto.setFirstName(employeeDto.getFirstName());
		employeeTaxDto.setLastName(employeeDto.getLastName());
		employeeTaxDto.setSalaryYearly(TaxUtil.getTotalSalary(employeeDto.getDoj(), employeeDto.getSalary()));
		employeeTaxDto.setTaxAmount(TaxUtil.getTax(employeeTaxDto.getSalaryYearly()));
		employeeTaxDto.setCessAmount(TaxUtil.getCess(employeeTaxDto.getSalaryYearly()));
		return employeeTaxDto;
	}

}
