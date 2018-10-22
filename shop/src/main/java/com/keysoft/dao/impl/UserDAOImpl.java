package com.keysoft.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keysoft.dao.UserDAO;
import com.keysoft.entity.UserEntity;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
@Autowired
SessionFactory sessionFactory;

public void addUser(UserEntity user) {
	sessionFactory.getCurrentSession().save(user);
	
}

public void updateUser(UserEntity user) {
	sessionFactory.getCurrentSession().merge(user);
	
}

public void deleteUser(int id) {
	sessionFactory.getCurrentSession().delete(getUserById(id));
	
}

public UserEntity getUserById(int id) {
	// TODO Auto-generated method stub
	return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, id);
}

public List<UserEntity> getAllUser() {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
	return criteria.list();
}


}
