package com.hp.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hp.converter.RoleConverter;
import com.hp.dao.RoleDAO;
import com.hp.dao.customer.RoleRepositoryCustomized;
import com.hp.entity.RoleEntity;
import com.hp.entity.UserEntity;
import com.hp.model.RoleDTO;
import com.hp.model.RoleUserCustom;
import com.hp.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	@Autowired
	RoleRepositoryCustomized roleCustom;
	@Autowired
	RoleConverter roleConverter;

	public void delete(RoleDTO deleted) {
		roleDAO.delete(roleConverter.DTO2entity(deleted));

	}

	public List<RoleDTO> findAll() {
		List<RoleEntity> listRole =  roleDAO.findAll();
		List<RoleDTO> listRoleDTO = new ArrayList<RoleDTO>();
		for (RoleEntity roleEntity : listRole) {
			listRoleDTO.add(roleConverter.entity2DTO(roleEntity));	
		}
		return listRoleDTO;
	}

	public Optional<RoleDTO> findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public RoleDTO save(RoleDTO persisted) {
		//RoleEntity roleEntity = roleDAO.save(roleConverter.DTO2entity(persisted));
		String name = roleDAO.findNameById(2);
		RoleEntity roleEntity2 = roleDAO.findById(2);
		List<RoleEntity> list = roleDAO.findByDescription("ADMIN");
		
		List<RoleEntity> list1 = roleDAO.findByDescriptionOrName("","ROLE_ADMIN");
		
		Long count = roleDAO.countByDescription("ADMIN");
		
		List<RoleEntity> list2 = roleDAO.findDistinctByDescription("ADMIN");
		
		List<RoleEntity> list3 = roleDAO.findTop2ByDescription("ADMIN");
		
//		List<RoleEntity> list4 = roleCustom.findByDescriptionContainsOrNameContainsAllIgnoreCase("",	"MAN");
		List<RoleUserCustom> list5 = roleCustom.findBySearchTerm("ROLE_ADMIN","test");
		
		
		

	    
		RoleDTO dto = new RoleDTO();
		Pageable pageable = new PageRequest(dto.getPage()-1, dto.getMaxPageItem());
		Page<RoleEntity> page = roleDAO.findByDescriptionContainsOrNameContainsAllIgnoreCase("", "",pageable);
		List<RoleEntity> entities = page.getContent();
		
		return null;
	}



}
