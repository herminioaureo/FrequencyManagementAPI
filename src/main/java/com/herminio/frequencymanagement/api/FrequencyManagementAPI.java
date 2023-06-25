package com.herminio.frequencymanagement.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herminio.frequencymanagement.model.Company;
import com.herminio.frequencymanagement.model.Employee;
import com.herminio.frequencymanagement.model.Frequency;
import com.herminio.frequencymanagement.service.FrequencyManagementService;
import com.herminio.frequencymanagement.validation.impl.CompanyValidation;
import com.herminio.frequencymanagement.validation.impl.EmployeeValidation;

@RestController
@RequestMapping("frequency")
public class FrequencyManagementAPI {
	
	 private static final Logger logger = LogManager.getLogger(FrequencyManagementAPI.class);
	 
	 @Autowired
	 private FrequencyManagementService service;
	 
	 @Autowired 
	 private CompanyValidation companyValidation;
	 
	 @Autowired 
	 private EmployeeValidation employeeValidation;
	 
	 @PostMapping(path = "company", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity saveCompany(@RequestBody Company request) {
		
		try {
			companyValidation.validate(request);
			service.saveCompany(request);
			return ResponseEntity.status(HttpStatus.OK).build();
		
		} catch (Exception e) {
			logger.error("Erro generico ao salvar empresa no banco de dados " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	 }
	 
	 
	 @PostMapping(path = "employee", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity saveEmployee(@RequestBody Employee request) {
		 
		try {
			employeeValidation.validate(request);
			service.saveEmployee(request);
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			logger.error("Erro generico ao salvar funcionario no banco de dados " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	 }
	 
	 @PostMapping(path = "frequency", 
		        consumes = MediaType.APPLICATION_JSON_VALUE, 
		        produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity saveFrequency(@RequestBody Frequency request) {
		 
		 
		try {
			service.saveFrequency(request);
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			logger.error("Erro generico ao salvar funcionario no banco de dados " + e.getCause().toString(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro generico ao salvar frequencia no banco de dados");
		}
	 }
	 
	 @GetMapping(path = "getAllFrequency")
	 public ResponseEntity getAllFrequency() {
		 
		try {
			return ResponseEntity.ok(service.getAllFrequencys());
			
		} catch (Exception e) {
			logger.error("Erro generico ao buscar frequencia no banco de dados " + e.getCause().toString(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro generico ao buscar frequencia no banco de dados");
		}
	 }
	 
	 @GetMapping(path = "getAllCompanies")
	 public ResponseEntity getAllCompanies() {
		 
		try {
			return ResponseEntity.ok(service.getAllCompanies());
			
		} catch (Exception e) {
			logger.error("Erro generico ao buscar companhias no banco de dados " + e.getCause().toString(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro generico ao buscar companhias no banco de dados");
		}
	 }
	 
	 @GetMapping(path = "getAllEmployees")
	 public ResponseEntity getAllEmployees() {
		 
		try {
			return ResponseEntity.ok(service.getAllEmployees());
			
		} catch (Exception e) {
			logger.error("Erro generico ao buscar funcionarios no banco de dados " + e.getCause().toString(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro generico ao buscar funcionarios no banco de dados");
		}
	 }
}
