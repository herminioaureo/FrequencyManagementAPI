package com.herminio.frequencymanagement.api;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herminio.frequencymanagement.entity.Empresa;
import com.herminio.frequencymanagement.entity.Funcionario;
import com.herminio.frequencymanagement.model.EmpresaDTO;
import com.herminio.frequencymanagement.model.FuncionarioDTO;
import com.herminio.frequencymanagement.model.RetornoServico;
import com.herminio.frequencymanagement.repository.EmpresaRepository;
import com.herminio.frequencymanagement.repository.FuncionarioRepository;
import com.herminio.frequencymanagement.util.Util;

@RestController
@RequestMapping("frequency")
public class FrequencyManagementAPI {
	
	 private static final Logger logger = LogManager.getLogger(FrequencyManagementAPI.class);
	 
	 @Autowired
	 private EmpresaRepository empresaRepository;
	 
	 @Autowired
	 private FuncionarioRepository funcionarioRepository;
	 
	 @PostMapping(path = "empresa", 
		        consumes = MediaType.APPLICATION_JSON_VALUE, 
		        produces = MediaType.APPLICATION_JSON_VALUE)
	 public RetornoServico salvarEmpresa(@RequestBody EmpresaDTO request) {
		 
		Integer codRetorno = 0;
		String mensagem = "SUCESSO";
		
		try {
			Empresa entity = Util.convertDTOToEmpresa(request);
			logger.info("Iniciando cadastro da compainha ".concat(entity.getNome()).concat( " no banco de dados..."));
			empresaRepository.save(entity);
			logger.info("Empresa salva no banco de dados! ");
			
		} catch (IllegalAccessException e) {
			codRetorno = -1;
			mensagem = "Erro IllegalAccessException ao salvar empresa no banco de dados " + e.getCause().toString();
			logger.error("Erro IllegalAccessException ao salvar empresa no banco de dados " + e.getCause().toString(),e);
		} catch (InvocationTargetException e) {
			codRetorno = -2;
			mensagem = "Erro InvocationTargetException ao salvar empresa no banco de dados " + e.getCause().toString();
			logger.error("Erro InvocationTargetException ao salvar empresa no banco de dados " + e.getCause().toString(),e);
		} catch (Exception e) {
			codRetorno = -3;
			mensagem = "Erro generico ao salvar empresa no banco de dados " +  e.getCause().toString();
			logger.error("Erro generico ao salvar empresa no banco de dados " + e.getCause().toString(),e);
		}
		
		return Util.montarRetornoServico(codRetorno, mensagem);
	 }
	 
	 
	 @PostMapping(path = "funcionario", 
		        consumes = MediaType.APPLICATION_JSON_VALUE, 
		        produces = MediaType.APPLICATION_JSON_VALUE)
	 public RetornoServico salvarFuncionario(@RequestBody FuncionarioDTO request) {
		 
		Integer codRetorno = 0;
		String mensagem = "SUCESSO";
		 
		try {
			Funcionario entity = Util.convertDTOToFuncionario(request);
			logger.info("Iniciando cadastro do funcionario ".concat(entity.getNome()).concat( " no banco de dados..."));
			funcionarioRepository.save(entity);
			logger.info("Funcionario salva no banco de dados! ");
			
		} catch (IllegalAccessException e) {
			codRetorno = -1;
			mensagem = "Erro IllegalAccessException ao salvar funcionario no banco de dados " + e.getMessage();
			logger.error("Erro IllegalAccessException ao salvar funcionario no banco de dados " + e.getMessage(),e);
		} catch (InvocationTargetException e) {
			codRetorno = -2;
			mensagem = "Erro InvocationTargetException ao salvar funcionario no banco de dados " + e.getCause().toString();
			logger.error("Erro InvocationTargetException ao salvar funcionario no banco de dados " + e.getCause().toString(),e);
		} catch (Exception e) {
			codRetorno = -3;
			mensagem = "Erro generico ao salvar funcionario no banco de dados " +  e.getCause().toString();
			logger.error("Erro generico ao salvar funcionario no banco de dados " + e.getCause().toString(),e);
		}
		
		return Util.montarRetornoServico(codRetorno, mensagem);
	 }
	 
	 @PostMapping(path = "frequencia", 
		        consumes = MediaType.APPLICATION_JSON_VALUE, 
		        produces = MediaType.APPLICATION_JSON_VALUE)
	 public RetornoServico salvarFrequencia(@RequestBody FuncionarioDTO request) {
		 
		Integer codRetorno = 0;
		String mensagem = "SUCESSO";
		 
		try {
			Funcionario entity = Util.convertDTOToFuncionario(request);
			logger.info("Iniciando cadastro do funcionario ".concat(entity.getNome()).concat( " no banco de dados..."));
			funcionarioRepository.save(entity);
			logger.info("Funcionario salva no banco de dados! ");
			
		} catch (IllegalAccessException e) {
			codRetorno = -1;
			mensagem = "Erro IllegalAccessException ao salvar funcionario no banco de dados " + e.getMessage();
			logger.error("Erro IllegalAccessException ao salvar funcionario no banco de dados " + e.getMessage(),e);
		} catch (InvocationTargetException e) {
			codRetorno = -2;
			mensagem = "Erro InvocationTargetException ao salvar funcionario no banco de dados " + e.getCause().toString();
			logger.error("Erro InvocationTargetException ao salvar funcionario no banco de dados " + e.getCause().toString(),e);
		} catch (Exception e) {
			codRetorno = -3;
			mensagem = "Erro generico ao salvar funcionario no banco de dados " +  e.getCause().toString();
			logger.error("Erro generico ao salvar funcionario no banco de dados " + e.getCause().toString(),e);
		}
		
		return Util.montarRetornoServico(codRetorno, mensagem);
	 }
}
