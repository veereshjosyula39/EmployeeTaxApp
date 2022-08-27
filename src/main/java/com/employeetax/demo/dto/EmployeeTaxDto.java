package com.employeetax.demo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class EmployeeTaxDto {

	public  EmployeeTaxDto() {
		
	};
	
	private Long employeeID;

	private String firstName;

	private String lastName;

	private Date doj;

	private Long salaryYearly;
	
	private Double taxAmount;
	
	private Double cessAmount;

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Long getSalaryYearly() {
		return salaryYearly;
	}

	public void setSalaryYearly(Long salaryYearly) {
		this.salaryYearly = salaryYearly;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
	}

	@Override
	public String toString() {
		return "EmployeeTaxDto [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", doj=" + doj + ", salaryYearly=" + salaryYearly + ", taxAmount=" + taxAmount + ", cessAmount="
				+ cessAmount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cessAmount, doj, employeeID, firstName, lastName, salaryYearly, taxAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeTaxDto other = (EmployeeTaxDto) obj;
		return Objects.equals(cessAmount, other.cessAmount) && Objects.equals(doj, other.doj)
				&& Objects.equals(employeeID, other.employeeID) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(salaryYearly, other.salaryYearly)
				&& Objects.equals(taxAmount, other.taxAmount);
	}
}
