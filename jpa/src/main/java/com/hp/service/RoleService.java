package com.hp.service;

import java.util.List;
import java.util.Optional;

import com.hp.model.RoleDTO;

public interface RoleService extends CRUDManagement<RoleDTO, Integer>{
void delete(RoleDTO t);
List<RoleDTO> findAll();
Optional<RoleDTO> findOne(Integer id);
RoleDTO save(RoleDTO persisted);

}
