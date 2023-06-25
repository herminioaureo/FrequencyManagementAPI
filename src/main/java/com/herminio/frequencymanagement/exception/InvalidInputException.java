package com.herminio.frequencymanagement.exception;

public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8128002725965715568L;
	
	public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }

}
