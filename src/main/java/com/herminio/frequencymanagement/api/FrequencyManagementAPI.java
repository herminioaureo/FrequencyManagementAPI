package com.herminio.frequencymanagement.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herminio.frequencymanagement.model.Company;
import com.herminio.frequencymanagement.model.Employee;
import com.herminio.frequencymanagement.service.FrequencyManagementService;

@RestController
@RequestMapping("frequency")
public class FrequencyManagementAPI {
	
	 private static final Logger logger = LogManager.getLogger(FrequencyManagementAPI.class);
	 
	 @Autowired
	 private FrequencyManagementService service;
	 
	 @PostMapping(path = "company", 
		        consumes = MediaType.APPLICATION_JSON_VALUE, 
		        produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity saveCompany(@RequestBody Company request) {
		
		try {
			service.saveCompany(request);
			return ResponseEntity.status(HttpStatus.OK).build();
		
		} catch (Exception e) {
			logger.error("Erro generico ao salvar empresa no banco de dados " + e.getCause().toString(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro generico ao salvar empresa no banco de dados");
		}
	 }
	 
	 
	 @PostMapping(path = "funcionario", 
		        consumes = MediaType.APPLICATION_JSON_VALUE, 
		        produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity saveEmployee(@RequestBody Employee request) {
		 
		 
		try {
			service.saveEmployee(request);
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			logger.error("Erro generico ao salvar funcionario no banco de dados " + e.getCause().toString(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro generico ao salvar funcionario no banco de dados");
		}
	 }
}
