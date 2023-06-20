package com.herminio.frequencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	private int idcompany;
	private String name;
	private String segment;
	private int uuid;

}