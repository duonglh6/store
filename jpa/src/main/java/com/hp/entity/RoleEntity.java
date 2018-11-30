package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="RoleEntity.findAll", query="SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to RoleUserEntity
	@OneToMany(mappedBy="role",fetch = FetchType.LAZY)
	private List<RoleUserEntity> roleUsers;

	public RoleEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleUserEntity> getRoleUsers() {
		return this.roleUsers;
	}

	public void setRoleUsers(List<RoleUserEntity> roleUsers) {
		this.roleUsers = roleUsers;
	}

	public RoleUserEntity addRoleUser(RoleUserEntity roleUser) {
		getRoleUsers().add(roleUser);
		roleUser.setRole(this);

		return roleUser;
	}

	public RoleUserEntity removeRoleUser(RoleUserEntity roleUser) {
		getRoleUsers().remove(roleUser);
		roleUser.setRole(null);

		return roleUser;
	}

}