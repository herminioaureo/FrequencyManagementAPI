package com.herminio.frequencymanagement.util;

import java.util.UUID;

import com.herminio.frequencymanagement.entity.CompanyEntity;
import com.herminio.frequencymanagement.entity.EmployeeEntity;
import com.herminio.frequencymanagement.model.Company;
import com.herminio.frequencymanagement.model.Employee;

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
}
