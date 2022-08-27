package com.employeetax.demo.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDto {

    private Long employeeID;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty(message = "Phone Number Cannot be empty")
	private List<String> phoneNumber; 
	
	private Date doj;
	

	private Long salary;
}
