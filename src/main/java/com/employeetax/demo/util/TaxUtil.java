package com.employeetax.demo.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TaxUtil {

	public static Long getTotalSalary(Date djo, Long salPerMonth, int lopDays) {
		Double salaryPerDay = (double) (salPerMonth / TaxConstants.WORKING_DAYS_PER_MONTH);
		int totalWorkingDays = getTotalWorkingDaysInCurrentFY(djo);
		double lop = salPerMonth / TaxConstants.LOSS_OF_PAY_PER_DAY_DIVIDER;
		return (long) (totalWorkingDays * salaryPerDay - lopDays * lop);
	}

	public static int getTotalWorkingDaysInCurrentFY(Date djo) {
		LocalDate startDate = convertToLocalDateViaInstant(djo);
		int fyEndYear = LocalDate.now().getYear();
		int emplJoinYear = startDate.getYear();
		int totalWorkingDays = TaxConstants.FY_TOTAL_MONTHS * TaxConstants.WORKING_DAYS_PER_MONTH;
		if (emplJoinYear >= fyEndYear - 1 && startDate.getMonthValue()>=Month.APRIL.getValue()) {
			startDate = convertToLocalDateViaInstant(djo).withDayOfMonth(1);
			LocalDate fyEndate = LocalDate.of(fyEndYear, Month.MARCH, TaxConstants.FY_END_DATE).withDayOfMonth(1);
			long months = ChronoUnit.MONTHS.between(fyEndate, startDate);
			int remaingDays = startDate.lengthOfMonth()-startDate.getDayOfMonth();
			totalWorkingDays = (int) (months*TaxConstants.WORKING_DAYS_PER_MONTH + remaingDays);
		}
		
		return totalWorkingDays;
	}

	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Double getTax(Long salary) {

		Double tax = 0.0;

		if (salary <= 250000)
			tax = 0.0;
		else if (salary <= 500000)
			tax = 0.05 * (salary - 250000);
		else if (salary <= 1000000)
			tax = (0.1 * (salary - 500000)) + (0.05 * 250000);
		else
			tax = (0.2 * (salary - 1000000)) + (0.1 * 500000) + (0.05 * 250000);

		return round(tax, 2);
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static Double getCess(Long salary) {

		Double totalCess = 0.0;

		if (salary > 2500000) {

			salary = Math.round(salary / 1000000.0) * 1000000;

			totalCess = (double) ((2 * salary) / 100);
		}

		return totalCess;
	}
}
