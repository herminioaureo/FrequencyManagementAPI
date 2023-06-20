package com.herminio.frequencymanagement.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.herminio.frequencymanagement.entity.CompanyEntity;
import com.herminio.frequencymanagement.entity.EmployeeEntity;
import com.herminio.frequencymanagement.entity.FrequencyEntity;
import com.herminio.frequencymanagement.model.Company;
import com.herminio.frequencymanagement.model.Employee;
import com.herminio.frequencymanagement.model.Frequency;

public class Util {

	public static CompanyEntity convertToEntity(Company company) {
		CompanyEntity entity = null;
		
		if (company != null) {
			entity = new CompanyEntity();
			entity.setName(company.getName());
			entity.setSegment(company.getSegment());
			entity.setUuid(UUID.randomUUID().toString());
		}
		return entity;
	}
	
	public static EmployeeEntity convertToEntity(Employee employee) {
		EmployeeEntity entity = null;
		
		if (employee != null) {
			entity = new EmployeeEntity();
			entity.setName(employee.getName());
			entity.setRole(employee.getRole());
			entity.setUuid(UUID.randomUUID().toString());
		}
		return entity;
	}
	
	public static FrequencyEntity convertToEntity(Frequency frequency) {
		FrequencyEntity entity = null;
		EmployeeEntity employee = null;
		CompanyEntity company = null;
		
		if (frequency != null) {
			entity = new FrequencyEntity();
			employee = new EmployeeEntity();
			company = new CompanyEntity();
			
			employee.setIdemployee(frequency.getEmployee().getIdemployee());
			company.setIdcompany(frequency.getCompany().getIdcompany());
			
			entity.setCompany(company);
			entity.setEmployee(employee);
			
			ZoneOffset zoneOffSet= ZoneOffset.of("-03:00");
			OffsetDateTime date = OffsetDateTime.now(zoneOffSet);
			
			entity.setDateTime(new Date().from(date.toInstant()));
			
			entity.setUuid(UUID.randomUUID().toString());
		}
		return entity;
	}
	
	public static Company convertToModel(CompanyEntity entity) {
		Company company = null;
		
		if (entity != null) {
			company = new Company();
			company.setIdcompany(entity.getIdcompany());
			company.setName(entity.getName());
			company.setSegment(entity.getSegment());
			company.setUuid(entity.getUuid());
		}
		return company;
	}
	
	public static Employee convertToModel(EmployeeEntity entity) {
		Employee employee = null;
		
		if (entity != null) {
			employee = new Employee();
			employee.setIdemployee(entity.getIdemployee());
			employee.setName(entity.getName());
			employee.setRole(entity.getRole());
			employee.setUuid(entity.getUuid());
		}
		return employee;
	}
	
	public static Frequency convertToModel(FrequencyEntity entity) {
		Frequency frequency = null;
		Employee employee = null;
		Company company = null;
		
		if (entity != null) {
			frequency = new Frequency();
			employee = convertToModel(entity.getEmployee());
			company = convertToModel(entity.getCompany());
			frequency.setCompany(company);
			frequency.setEmployee(employee);
			frequency.setDateTime(entity.getDateTime());
			frequency.setIdfrequency(entity.getIdfrequency());
			frequency.setUuid(entity.getUuid());
		}
		return frequency;
	}
}
