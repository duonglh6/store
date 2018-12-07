package com.hp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.SessionDetailRepository;
import com.hp.model.SessionDetail;
import com.hp.service.SessionDetailManagement;

@Service
@Transactional
public class SessionDetailService implements SessionDetailManagement{
	
	SessionDetailRepository sessionDetailRepository;

	public void delete(SessionDetail model) {
		sessionDetailRepository.delete(model);
		
	}

	public List<SessionDetail> findAll() {
		return sessionDetailRepository.findAll();
	}

	public SessionDetail findOne(Integer id) {
		return sessionDetailRepository.findOne(id);
	}

	public SessionDetail save(SessionDetail model) {
		return sessionDetailRepository.save(model);
	}

}
