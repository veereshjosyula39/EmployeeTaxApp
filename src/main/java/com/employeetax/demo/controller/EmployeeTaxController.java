package com.employeetax.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeetax.demo.dto.EmployeeDto;
import com.employeetax.demo.dto.EmployeeTaxDto;
import com.employeetax.demo.service.EmployeeService;
import com.employeetax.demo.service.EmployeeServiceTaxService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeTaxController {

	@Autowired
	EmployeeServiceTaxService employeeServiceTaxService;
	
	@GetMapping(value = "/employeeTax", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeTaxDto>> saveCustomer(@Valid @RequestBody EmployeeDto employeeDto) {
		try {
			return new ResponseEntity<List<EmployeeTaxDto>>(employeeServiceTaxService.getEmployeesTax(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
