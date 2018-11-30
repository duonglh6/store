package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="account_status")
	private int accountStatus;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	private String email;

	private int enabled;

	private String fullname;

	@Column(name="modified_by")
	private String modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="modified_date")
	private Date modifiedDate;

	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="password_change_date")
	private Date passwordChangeDate;

	private String username;

	//bi-directional many-to-one association to RoleUserEntity
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<RoleUserEntity> roleUsers;

	public UserEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasswordChangeDate() {
		return this.passwordChangeDate;
	}

	public void setPasswordChangeDate(Date passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<RoleUserEntity> getRoleUsers() {
		return this.roleUsers;
	}

	public void setRoleUsers(List<RoleUserEntity> roleUsers) {
		this.roleUsers = roleUsers;
	}

	public RoleUserEntity addRoleUser(RoleUserEntity roleUser) {
		getRoleUsers().add(roleUser);
		roleUser.setUser(this);

		return roleUser;
	}

	public RoleUserEntity removeRoleUser(RoleUserEntity roleUser) {
		getRoleUsers().remove(roleUser);
		roleUser.setUser(null);

		return roleUser;
	}

}