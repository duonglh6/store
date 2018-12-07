package com.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.PatientRepository;
import com.hp.model.Patient;
import com.hp.service.PatientManagement;

@Service
@Transactional
public class PatientService implements PatientManagement {
	
	
	@Autowired
	PatientRepository patientRepository;

	public void delete(Patient model) {
		patientRepository.delete(model);
		
	}

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	public Patient findOne(Integer id) {
		return  patientRepository.findOne(id);
	}

	public Patient save(Patient model) {
		return patientRepository.save(model);
	}

}
