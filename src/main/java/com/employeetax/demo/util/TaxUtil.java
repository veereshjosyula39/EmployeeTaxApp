package com.employeetax.demo.util;

import java.util.Date;

public class TaxUtil {

	public static Long getTotalSalary(Date djo, Long salPerMonth ) {
        Long totalSalary =salPerMonth*12;
		return totalSalary;
	}
	
	public static Double getTax(Long salary) {

		Double totalTax = 0.0;

		if (salary > 250000 && salary <= 500000) {
			totalTax = totalTax + (double) ((5 * salary) / 100);
		}
		if (salary > 500000 && salary <= 1000000) {
			totalTax = totalTax + (double) ((10 * salary) / 100);
		}
		if (salary > 1000000) {
			totalTax = totalTax + (double) ((20 * salary) / 100);
		}
		return totalTax;
	}

	public static Double getCess(Long salary) {

		Double totalCess = 0.0;

		if (salary > 2500000) {
			
			salary = Math.round(salary/1000000.0) * 1000000;
			
			totalCess = (double) ((2 * salary) / 100);
		}
		
		return totalCess;
	}
}
