package com.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.DoctorRepository;
import com.hp.model.Doctor;
import com.hp.service.DoctorManagement;

@Service
@Transactional
public class DoctorService implements DoctorManagement{
	@Autowired
	DoctorRepository doctorRepository;

	public void delete(Doctor model) {
		doctorRepository.delete(model);
		
	}

	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	public Doctor findOne(Integer id) {
		return doctorRepository.findOne(id);
	}

	public Doctor save(Doctor model) {
		return doctorRepository.save(model);
	}

}
