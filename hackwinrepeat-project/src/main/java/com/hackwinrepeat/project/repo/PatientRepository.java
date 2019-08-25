package com.hackwinrepeat.project.repo;

import org.springframework.data.repository.CrudRepository;

import com.hackwinrepeat.project.beans.PatientEntity;

public interface PatientRepository extends CrudRepository<PatientEntity , Long> {
	
	PatientEntity findPatientById(Long email);
	
}
