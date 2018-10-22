package com.keysoft.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keysoft.dao.RoleDAO;
import com.keysoft.entity.RoleEntity;
@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void addRole(RoleEntity role) {
		sessionFactory.getCurrentSession().save(role);
		
	}

	public void updateRole(RoleEntity role) {
		sessionFactory.getCurrentSession().merge(role);
		
	}

	public void deleteRole(int id) {
		sessionFactory.getCurrentSession().delete(getRoleById(id));
		
	}

	public RoleEntity getRoleById(int id) {
		// TODO Auto-generated method stub
		return (RoleEntity) sessionFactory.getCurrentSession().get(RoleEntity.class, id);
	}

	public List<RoleEntity> getAllRole() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleEntity.class);
		return criteria.list();
	}

}
