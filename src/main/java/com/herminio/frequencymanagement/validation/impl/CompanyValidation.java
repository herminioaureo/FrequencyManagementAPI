package com.herminio.frequencymanagement.validation.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.herminio.frequencymanagement.exception.InvalidInputException;
import com.herminio.frequencymanagement.model.Company;
import com.herminio.frequencymanagement.validation.Validation;

@Service
public class CompanyValidation implements Validation {

	@Override
	public void validate(Object obj) throws InvalidInputException {
		
		Company company = (Company) obj;
		
		if (StringUtils.isEmpty(company.getName()) || StringUtils.isEmpty(company.getSegment())) {
			throw new InvalidInputException("Invalid input. Name and segment are mandatory.");
		}

	}

}
