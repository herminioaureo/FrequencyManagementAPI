package com.herminio.frequencymanagement.model;

public class RetornoServico {

	private Integer codigo;
	private String mensagem;
	
	public RetornoServico() {}
	
	public RetornoServico(Integer codigo, String mensagem) {
		setCodigo(codigo);
		setMensagem(mensagem);
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
