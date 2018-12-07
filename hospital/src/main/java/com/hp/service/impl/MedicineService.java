package com.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.MedicineRepository;
import com.hp.model.Medicine;
import com.hp.service.MedicineManagement;

@Service
@Transactional
public class MedicineService implements MedicineManagement{
	
	@Autowired
	MedicineRepository medicineRepository;

	public void delete(Medicine model) {
		medicineRepository.delete(model);
		
	}

	public List<Medicine> findAll() {
		return medicineRepository.findAll();
	}

	public Medicine findOne(Integer id) {
		return medicineRepository.findOne(id);
	}

	public Medicine save(Medicine model) {
		return medicineRepository.save(model);
	}

}
