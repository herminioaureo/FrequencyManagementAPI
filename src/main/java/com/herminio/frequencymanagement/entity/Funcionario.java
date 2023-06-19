package com.herminio.frequencymanagement.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfuncionario;

	private String cargo;

	@Column(name="id_empresa")
	private int idEmpresa;

	private String nome;

	//bi-directional many-to-one association to Frequencia
	@OneToMany(mappedBy="funcionario")
	private List<Frequencia> frequencias;

	public Funcionario() {
	}

	public int getIdfuncionario() {
		return this.idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Frequencia> getFrequencias() {
		return this.frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public Frequencia addFrequencia(Frequencia frequencia) {
		getFrequencias().add(frequencia);
		frequencia.setFuncionario(this);

		return frequencia;
	}

	public Frequencia removeFrequencia(Frequencia frequencia) {
		getFrequencias().remove(frequencia);
		frequencia.setFuncionario(null);

		return frequencia;
	}

}