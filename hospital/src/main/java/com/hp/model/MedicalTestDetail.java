package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the medical_test_detail database table.
 * 
 */
@Entity
@Table(name="medical_test_detail")
@NamedQuery(name="MedicalTestDetail.findAll", query="SELECT m FROM MedicalTestDetail m")
public class MedicalTestDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private String laboratory_technician;

	@Column(name="url_result")
	private String urlResult;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="working_time")
	private Date workingTime;

	//bi-directional many-to-one association to MedicalTest
	@ManyToOne
	@JoinColumn(name="medical_test_id")
	private MedicalTest medicalTest;

	//bi-directional many-to-one association to Session
	@ManyToOne
	private Session session;

	public MedicalTestDetail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLaboratory_technician() {
		return this.laboratory_technician;
	}

	public void setLaboratory_technician(String laboratory_technician) {
		this.laboratory_technician = laboratory_technician;
	}

	public String getUrlResult() {
		return this.urlResult;
	}

	public void setUrlResult(String urlResult) {
		this.urlResult = urlResult;
	}

	public Date getWorkingTime() {
		return this.workingTime;
	}

	public void setWorkingTime(Date workingTime) {
		this.workingTime = workingTime;
	}

	public MedicalTest getMedicalTest() {
		return this.medicalTest;
	}

	public void setMedicalTest(MedicalTest medicalTest) {
		this.medicalTest = medicalTest;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}