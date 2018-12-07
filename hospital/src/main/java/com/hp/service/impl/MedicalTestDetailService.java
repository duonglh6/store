package com.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.MedicalTestDetailRepository;
import com.hp.model.MedicalTestDetail;
import com.hp.service.MedicalTestDetailManagement;

@Service
@Transactional
public class MedicalTestDetailService implements MedicalTestDetailManagement{

	@Autowired
	MedicalTestDetailRepository medicalTestDetailRepository; 

	public void delete(MedicalTestDetail model) {
		medicalTestDetailRepository.delete(model);
		
	}

	public List<MedicalTestDetail> findAll() {
		return medicalTestDetailRepository.findAll();
	}

	public MedicalTestDetail findOne(Integer id) {
		return medicalTestDetailRepository.findOne(id);
	}

	public MedicalTestDetail save(MedicalTestDetail model) {
		return medicalTestDetailRepository.save(model);
	}

}
