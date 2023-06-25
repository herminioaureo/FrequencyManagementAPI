package com.herminio.frequencymanagement.validation;

import com.herminio.frequencymanagement.exception.InvalidInputException;

public interface Validation {
	
	public void validate(Object obj) throws InvalidInputException;

}
