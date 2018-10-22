package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.keysoft.model.RoleDTO;

import java.util.List;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role")
@NamedQuery(name = "RoleEntity.findAll", query = "SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	// bi-directional many-to-one association to UserEntity
	@OneToMany(mappedBy = "role")
	private List<UserEntity> users;

	public RoleEntity() {
	}

	public RoleEntity(RoleDTO role) {
		super();
		this.roleId = role.getRoleId();
		this.roleName = role.getRoleName();
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity addUser(UserEntity user) {
		getUsers().add(user);
		user.setRole(this);

		return user;
	}

	public UserEntity removeUser(UserEntity user) {
		getUsers().remove(user);
		user.setRole(null);

		return user;
	}

}