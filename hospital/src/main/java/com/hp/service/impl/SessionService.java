package com.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.SessionRepository;
import com.hp.model.Session;
import com.hp.service.SessionManagement;

@Service
@Transactional
public class SessionService implements SessionManagement{
	@Autowired
	SessionRepository sessionRepository;

	public void delete(Session model) {
		sessionRepository.delete(model);
		
	}

	public List<Session> findAll() {
		return sessionRepository.findAll();
	}

	public Session findOne(Integer id) {
		return sessionRepository.findOne(id);
	}

	public Session save(Session model) {
		return sessionRepository.save(model);
	}

}
