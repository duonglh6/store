package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String address;

	private String code;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String fullname;

	@Column(name="phone_number")
	private String phoneNumber;

	private String position;

	private int status;

	//bi-directional many-to-many association to Specialize
	@ManyToMany(mappedBy="doctors")
	private List<Specialize> specializes;

	//bi-directional many-to-one association to SessionDetail
	@OneToMany(mappedBy="doctor")
	private List<SessionDetail> sessionDetails;

	public Doctor() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Specialize> getSpecializes() {
		return this.specializes;
	}

	public void setSpecializes(List<Specialize> specializes) {
		this.specializes = specializes;
	}

	public List<SessionDetail> getSessionDetails() {
		return this.sessionDetails;
	}

	public void setSessionDetails(List<SessionDetail> sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	public SessionDetail addSessionDetail(SessionDetail sessionDetail) {
		getSessionDetails().add(sessionDetail);
		sessionDetail.setDoctor(this);

		return sessionDetail;
	}

	public SessionDetail removeSessionDetail(SessionDetail sessionDetail) {
		getSessionDetails().remove(sessionDetail);
		sessionDetail.setDoctor(null);

		return sessionDetail;
	}

}