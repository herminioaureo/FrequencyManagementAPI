package com.herminio.frequencymanagement.validation.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.herminio.frequencymanagement.exception.InvalidInputException;
import com.herminio.frequencymanagement.model.Employee;
import com.herminio.frequencymanagement.validation.Validation;

@Service
public class EmployeeValidation implements Validation {

	@Override
	public void validate(Object obj) throws InvalidInputException {
		
		Employee company = (Employee) obj;
		
		if (StringUtils.isEmpty(company.getName()) || StringUtils.isEmpty(company.getRole())) {
			throw new InvalidInputException("Invalid input. Name and role are mandatory.");
		}

	}

}
