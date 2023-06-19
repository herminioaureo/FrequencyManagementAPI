package com.herminio.frequencymanagement.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpresa;

	private String nome;

	private String segmento;

	//bi-directional many-to-one association to Frequencia
	@OneToMany(mappedBy="empresa")
	private List<Frequencia> frequencias;

	public Empresa() {
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

	public String getSegmento() {
		return this.segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public List<Frequencia> getFrequencias() {
		return this.frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public Frequencia addFrequencia(Frequencia frequencia) {
		getFrequencias().add(frequencia);
		frequencia.setEmpresa(this);

		return frequencia;
	}

	public Frequencia removeFrequencia(Frequencia frequencia) {
		getFrequencias().remove(frequencia);
		frequencia.setEmpresa(null);

		return frequencia;
	}

}