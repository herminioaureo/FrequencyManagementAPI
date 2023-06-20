package com.herminio.frequencymanagement.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity(name = "Employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idemployee;

	private String name;

	private String role;

	private String uuid;

	//bi-directional many-to-one association to Frequency
	@OneToMany(mappedBy="employee")
	private List<FrequencyEntity> frequencies;

	public EmployeeEntity() {
	}

	public int getIdemployee() {
		return this.idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<FrequencyEntity> getFrequencies() {
		return this.frequencies;
	}

	public void setFrequencies(List<FrequencyEntity> frequencies) {
		this.frequencies = frequencies;
	}

	public FrequencyEntity addFrequency(FrequencyEntity frequency) {
		getFrequencies().add(frequency);
		frequency.setEmployee(this);

		return frequency;
	}

	public FrequencyEntity removeFrequency(FrequencyEntity frequency) {
		getFrequencies().remove(frequency);
		frequency.setEmployee(null);

		return frequency;
	}
}