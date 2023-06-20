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
 * The persistent class for the company database table.
 * 
 */
@Entity(name = "Company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class CompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcompany;

	private String name;

	private String segment;

	private String uuid;

	//bi-directional many-to-one association to Frequency
	@OneToMany(mappedBy="company")
	private List<FrequencyEntity> frequencies;

	public CompanyEntity() {
	}

	public int getIdcompany() {
		return this.idcompany;
	}

	public void setIdcompany(int idcompany) {
		this.idcompany = idcompany;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
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
		frequency.setCompany(this);

		return frequency;
	}

	public FrequencyEntity removeFrequency(FrequencyEntity frequency) {
		getFrequencies().remove(frequency);
		frequency.setCompany(null);

		return frequency;
	}

}