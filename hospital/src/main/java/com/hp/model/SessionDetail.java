package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the session_detail database table.
 * 
 */
@Entity
@Table(name="session_detail")
@NamedQuery(name="SessionDetail.findAll", query="SELECT s FROM SessionDetail s")
public class SessionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	private String reason;

	@Column(name="url_result")
	private String urlResult;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="working_time")
	private Date workingTime;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	private Doctor doctor;

	//bi-directional many-to-one association to Session
	@ManyToOne
	private Session session;

	public SessionDetail() {
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

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}