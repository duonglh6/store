package com.keysoft.model;

import com.keysoft.entity.RoleEntity;

public class RoleDTO {
	private int roleId;
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleDTO(RoleEntity role) {
		super();
		this.roleId = role.getRoleId();
		this.roleName = role.getRoleName();
	}

	public RoleDTO() {
		super();
	}

}
