package com.hackwinrepeat.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hackwinrepeat.project.beans.PatientDetailsDTO;
import com.hackwinrepeat.project.beans.PatientDetailsRequest;
import com.hackwinrepeat.project.beans.PatientResponseDetails;
import com.hackwinrepeat.project.service.QuestService;
import com.hackwinrepeat.project.service.email.EmailService;

@RestController
@RequestMapping("patient") //http://localhost:8080/patient
public class QuestController {
	
	@Autowired
	QuestService questService;
	
	@Autowired
	EmailService emailService;
	
	
	@PostMapping
	public String createUser(@RequestBody PatientDetailsRequest patientDetailsRequest) {
		
		PatientDetailsDTO patientDetailsDTO = new PatientDetailsDTO();
		BeanUtils.copyProperties(patientDetailsRequest, patientDetailsDTO);
		
		PatientDetailsDTO createdPatient = questService.createPatient(patientDetailsDTO);
		
		if(createdPatient !=null) {
			return "Patient is created";
		}
		
		return "Patient creation fails";
	}
	
	@GetMapping(path = "/{id}")
	public String recommendedTest(@PathVariable Long id) throws Exception {
		
		String result = null;
		PatientDetailsDTO patientDetailsDTO = questService.getPatientById(id);
		if(patientDetailsDTO !=null) {
			if("Positive".equalsIgnoreCase(patientDetailsDTO.getDiseaseA()) 
					&& "Positive".equalsIgnoreCase(patientDetailsDTO.getDiseaseB())) {
				//send email to patient to do test C
				//emailService.sendEmail(patientDetailsDTO.getName(),patientDetailsDTO.getEmail());
				System.out.println("Sending request to micro service....");
				String url = "http://localhost:8081/sendEmail";
				Map<String, String> args = new HashMap<String, String>();
				args.put("name", patientDetailsDTO.getName());
				args.put("email", patientDetailsDTO.getEmail());
		        
		        RestTemplate client = new RestTemplate();
		        
		        result = client.postForObject(url, args, String.class);
		        System.out.println("Get response from micro service successfully....");
			}
		}
		
		PatientResponseDetails PatientResponseDetails = new PatientResponseDetails();
		BeanUtils.copyProperties(patientDetailsDTO, PatientResponseDetails);
		if(result==null) {
			return "micro service fails";
		}
		return result;
	}

}
