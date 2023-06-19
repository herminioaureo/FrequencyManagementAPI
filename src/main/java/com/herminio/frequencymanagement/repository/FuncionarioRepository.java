package com.herminio.frequencymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herminio.frequencymanagement.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { } 
