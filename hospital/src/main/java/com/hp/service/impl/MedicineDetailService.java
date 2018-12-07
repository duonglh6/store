package com.hp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.MedicineDetailRepository;
import com.hp.model.MedicineDetail;
import com.hp.service.MedicineDetailManagement;

@Service
@Transactional
public class MedicineDetailService implements MedicineDetailManagement{
	
	MedicineDetailRepository medicineDetailRepository;

	public void delete(MedicineDetail model) {
		medicineDetailRepository.delete(model);
		
	}

	public List<MedicineDetail> findAll() {
		return medicineDetailRepository.findAll();
	}

	public MedicineDetail findOne(Integer id) {
		return medicineDetailRepository.findOne(id);
	}

	public MedicineDetail save(MedicineDetail model) {
		return medicineDetailRepository.save(model);
	}

}
