package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.keysoft.model.UserDTO;

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
	@Column(name="user_id")
	private int userId;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	private String email;

	@Column(name="full_name")
	private String fullName;

	private byte gender;

	@Column(name="identity_number")
	private String identityNumber;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;

	private String username;

	//bi-directional many-to-one association to BillEntity
	@OneToMany(mappedBy="user")
	private List<BillEntity> bills;

	//bi-directional many-to-one association to CommentEntity
	@OneToMany(mappedBy="user")
	private List<CommentEntity> comments;

	//bi-directional many-to-one association to RoleEntity
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleEntity role;

	public UserEntity() {
	}
	

	public UserEntity(UserDTO user) {
		super();
		this.userId = userId;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.fullName = fullName;
		this.gender = gender;
		this.identityNumber = identityNumber;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.bills = bills;
		this.comments = comments;
		this.role = role;
	}


	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<BillEntity> getBills() {
		return this.bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public BillEntity addBill(BillEntity bill) {
		getBills().add(bill);
		bill.setUser(this);

		return bill;
	}

	public BillEntity removeBill(BillEntity bill) {
		getBills().remove(bill);
		bill.setUser(null);

		return bill;
	}

	public List<CommentEntity> getComments() {
		return this.comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public CommentEntity addComment(CommentEntity comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public CommentEntity removeComment(CommentEntity comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public RoleEntity getRole() {
		return this.role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

}