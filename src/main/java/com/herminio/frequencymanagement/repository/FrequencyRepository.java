package com.herminio.frequencymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herminio.frequencymanagement.entity.FrequencyEntity;

public interface FrequencyRepository extends JpaRepository<FrequencyEntity, Long> { } 
