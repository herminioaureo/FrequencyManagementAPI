package com.herminio.frequencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the user database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  {

	private int iduser;
	private String name;
	private String password;

}