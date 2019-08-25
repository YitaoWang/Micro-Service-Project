package com.hackwinrepeat.project.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackwinrepeat.project.beans.PatientDetailsDTO;
import com.hackwinrepeat.project.beans.PatientEntity;
import com.hackwinrepeat.project.repo.PatientRepository;
import com.hackwinrepeat.project.service.QuestService;


@Service
public class QuestServiceImp implements QuestService {
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public PatientDetailsDTO createPatient(PatientDetailsDTO patientDTO) {
		// TODO Auto-generated method stub
		PatientEntity patientEntity = new PatientEntity();
		BeanUtils.copyProperties(patientDTO, patientEntity);
		
		PatientEntity storedPatientDetails = patientRepository.save(patientEntity);
		PatientDetailsDTO storedPatientDetailsDTO = new PatientDetailsDTO();
		
		BeanUtils.copyProperties(storedPatientDetails, storedPatientDetailsDTO);
		return storedPatientDetailsDTO;
	}

	@Override
	public PatientDetailsDTO getPatientById(Long id) {
		// TODO Auto-generated method stub
		
		PatientEntity storedPatientDetails = patientRepository.findPatientById(id);
		
		PatientDetailsDTO storedPatientDetailsDTO = new PatientDetailsDTO();
		BeanUtils.copyProperties(storedPatientDetails, storedPatientDetailsDTO);
		
		return storedPatientDetailsDTO;
	}

}
