package com.herminio.frequencymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herminio.frequencymanagement.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> { } 
