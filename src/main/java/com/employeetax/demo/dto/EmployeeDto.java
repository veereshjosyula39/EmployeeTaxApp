package com.employeetax.demo.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDto {
	@Min(value = 0L, message = "The value must be positive")
	private Long employeeID;

	@NotEmpty(message = "First name Cannot be empty")
	private String firstName;

	@NotEmpty(message = "Last name Cannot be empty")
	private String lastName;

	@NotEmpty(message = "Email Cannot be empty")
	@Email
	private String email;

	@NotEmpty(message = "Phone Number Cannot be empty")
	private List<String> phoneNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date doj;

	@Min(value = 0L, message = "The value must be positive")
	private Long salary;
}
