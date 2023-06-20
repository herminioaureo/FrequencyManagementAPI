package com.herminio.frequencymanagement.model;

import java.util.Date;

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
	private String uuid;
	private Company company;
	private Employee employee;
	
}