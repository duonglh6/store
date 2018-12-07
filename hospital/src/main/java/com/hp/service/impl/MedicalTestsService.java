package com.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.MedicalTestRepository;
import com.hp.model.MedicalTest;
import com.hp.service.MedicalTestsManagement;

@Service
@Transactional
public class MedicalTestsService implements MedicalTestsManagement{
	@Autowired
	MedicalTestRepository medicalTestRepository; 

	public void delete(MedicalTest model) {
		medicalTestRepository.delete(model);
		
	}

	public List<MedicalTest> findAll() {
		return medicalTestRepository.findAll();
	}

	public MedicalTest findOne(Integer id) {
		return medicalTestRepository.findOne(id);
	}

	public MedicalTest save(MedicalTest model) {
		return medicalTestRepository.save(model);
	}

}
