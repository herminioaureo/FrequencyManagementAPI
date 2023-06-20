package com.herminio.frequencymanagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.herminio.frequencymanagement.api.FrequencyManagementAPI;
import com.herminio.frequencymanagement.entity.CompanyEntity;
import com.herminio.frequencymanagement.entity.EmployeeEntity;
import com.herminio.frequencymanagement.entity.FrequencyEntity;
import com.herminio.frequencymanagement.model.Company;
import com.herminio.frequencymanagement.model.Employee;
import com.herminio.frequencymanagement.model.Frequency;
import com.herminio.frequencymanagement.repository.CompanyRepository;
import com.herminio.frequencymanagement.repository.EmployeeRepository;
import com.herminio.frequencymanagement.repository.FrequencyRepository;
import com.herminio.frequencymanagement.util.Util;

@Component
public class FrequencyManagementService {
	
	 @Autowired
	 private CompanyRepository companyRepository;
	 
	 @Autowired
	 private EmployeeRepository employeeRepository;
	 
	 @Autowired
	 private FrequencyRepository frequencyRepository;
	 
	 private static final Logger logger = LogManager.getLogger(FrequencyManagementAPI.class);
	
	public void saveCompany(Company company) throws Exception {
		CompanyEntity entity = Util.convertToEntity(company);
		
		logger.info("Iniciando cadastro da compainha ".concat(entity.getName()).concat( " no banco de dados..."));
		companyRepository.save(entity);
		logger.info("Empresa salva no banco de dados! ");
		
	}
	
	public void saveEmployee(Employee employee) throws Exception {
		EmployeeEntity entity = Util.convertToEntity(employee);
		
		logger.info("Iniciando cadastro do funcionario ".concat(entity.getName()).concat( " no banco de dados..."));
		employeeRepository.save(entity);
		logger.info("Funcionario salva no banco de dados! ");
	}
	
	
	public void saveFrequency(Frequency frequency) throws Exception {
		FrequencyEntity entity = Util.convertToEntity(frequency);
		
		logger.info("Iniciando cadastro da frequencia no banco de dados");
		frequencyRepository.save(entity);
		logger.info("Frequencia salva no banco de dados! ");
	}

}
