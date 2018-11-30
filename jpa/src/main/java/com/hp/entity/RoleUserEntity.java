package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_user database table.
 * 
 */
@Entity
@Table(name="role_user")
@NamedQuery(name="RoleUserEntity.findAll", query="SELECT r FROM RoleUserEntity r")
public class RoleUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RoleEntity
	@ManyToOne
	private RoleEntity role;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	private UserEntity user;

	public RoleUserEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleEntity getRole() {
		return this.role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}