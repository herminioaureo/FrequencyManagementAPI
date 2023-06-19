package com.herminio.frequencymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herminio.frequencymanagement.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> { }


