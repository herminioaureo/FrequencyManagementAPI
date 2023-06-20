package com.herminio.frequencymanagement.model;

import java.util.Date;

import com.herminio.frequencymanagement.entity.CompanyEntity;
import com.herminio.frequencymanagement.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Frequency {
	
	private int idfrequency;
	private Date dateTime;
	private int uuid;
	private CompanyEntity company;
	private EmployeeEntity employee;
	
}