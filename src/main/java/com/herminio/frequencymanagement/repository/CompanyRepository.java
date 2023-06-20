package com.herminio.frequencymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herminio.frequencymanagement.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> { }


