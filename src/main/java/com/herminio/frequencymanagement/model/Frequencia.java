package com.herminio.frequencymanagement.model;

import java.sql.Time;
import java.util.Date;

public class FrequenciaDTO {
	
	private int idfrequencia;
	private Date data;
	private Time hora;
	private Integer idEmpresa;
	private Integer idFuncionario;
	
	public int getIdfrequencia() {
		return idfrequencia;
	}
	public void setIdfrequencia(int idfrequencia) {
		this.idfrequencia = idfrequencia;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}
