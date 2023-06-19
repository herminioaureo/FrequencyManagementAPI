package com.herminio.frequencymanagement.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.herminio.frequencymanagement.entity.Empresa;
import com.herminio.frequencymanagement.entity.Frequencia;
import com.herminio.frequencymanagement.entity.Funcionario;
import com.herminio.frequencymanagement.model.EmpresaDTO;
import com.herminio.frequencymanagement.model.FrequenciaDTO;
import com.herminio.frequencymanagement.model.FuncionarioDTO;
import com.herminio.frequencymanagement.model.RetornoServico;

public class Util {

	/**
	 * Metodo que converte um objeto Empresa em um EmpresaDTO
	 * @param dto
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Empresa convertDTOToEmpresa(EmpresaDTO dto) throws IllegalAccessException, InvocationTargetException {
		
		Empresa obj = new Empresa();
		
		if (dto != null) {
			obj.setNome(dto.getNome());
			obj.setSegmento(dto.getSegmento());
		}

		return obj;
	}
	
	/**
	 * Metodo que converte um objeto Funcionario um Funcionario
	 * @param dto
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Funcionario convertDTOToFuncionario(FuncionarioDTO dto)
			throws IllegalAccessException, InvocationTargetException {

		Funcionario obj = new Funcionario();

		if (dto != null) {
			obj.setNome(dto.getNome());
			obj.setCargo(dto.getCargo());
			obj.setIdEmpresa(dto.getIdEmpresa());
		}

		return obj;
	}
	
	/**
	 * Metodo que converte um objeto Funcionario um Funcionario
	 * @param dto
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Frequencia convertDTOToFrequencia(FrequenciaDTO dto)
			throws IllegalAccessException, InvocationTargetException {

		Frequencia obj = new Frequencia();
		Empresa emp = new Empresa();
		emp.setIdEmpresa(dto.getIdEmpresa());
		
		Funcionario fun = new Funcionario();
		fun.setIdfuncionario(dto.getIdFuncionario());

		
		Calendar calendarData = new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
		Calendar calendarHour = new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND);
		
		if (dto != null) {
			obj.setEmpresa(emp);
			obj.setFuncionario(fun);
			obj.setData(calendarData.getTime());
			
		}

		return obj;
	}
	
	
	public static RetornoServico montarRetornoServico(Integer codigo, String mensagem) {
		return new RetornoServico(codigo, mensagem);
	}
	

}
