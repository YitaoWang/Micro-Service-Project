package com.hackwinrepeat.project.service;

import com.hackwinrepeat.project.beans.PatientDetailsDTO;

public interface QuestService {
	
	PatientDetailsDTO createPatient(PatientDetailsDTO patientDTO);
	
	PatientDetailsDTO getPatientById(Long id);

}
