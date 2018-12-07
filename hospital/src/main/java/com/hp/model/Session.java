package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String code;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private String diagnosis;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="follow_up_examination")
	private Date followUpExamination;

	private String note;

	private int status;

	private String symptom;

	//bi-directional many-to-one association to MedicalTestDetail
	@OneToMany(mappedBy="session")
	private List<MedicalTestDetail> medicalTestDetails;

	//bi-directional many-to-one association to MedicineDetail
	@OneToMany(mappedBy="session")
	private List<MedicineDetail> medicineDetails;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	private Patient patient;

	//bi-directional many-to-one association to SessionDetail
	@OneToMany(mappedBy="session")
	private List<SessionDetail> sessionDetails;

	public Session() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Date getFollowUpExamination() {
		return this.followUpExamination;
	}

	public void setFollowUpExamination(Date followUpExamination) {
		this.followUpExamination = followUpExamination;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public List<MedicalTestDetail> getMedicalTestDetails() {
		return this.medicalTestDetails;
	}

	public void setMedicalTestDetails(List<MedicalTestDetail> medicalTestDetails) {
		this.medicalTestDetails = medicalTestDetails;
	}

	public MedicalTestDetail addMedicalTestDetail(MedicalTestDetail medicalTestDetail) {
		getMedicalTestDetails().add(medicalTestDetail);
		medicalTestDetail.setSession(this);

		return medicalTestDetail;
	}

	public MedicalTestDetail removeMedicalTestDetail(MedicalTestDetail medicalTestDetail) {
		getMedicalTestDetails().remove(medicalTestDetail);
		medicalTestDetail.setSession(null);

		return medicalTestDetail;
	}

	public List<MedicineDetail> getMedicineDetails() {
		return this.medicineDetails;
	}

	public void setMedicineDetails(List<MedicineDetail> medicineDetails) {
		this.medicineDetails = medicineDetails;
	}

	public MedicineDetail addMedicineDetail(MedicineDetail medicineDetail) {
		getMedicineDetails().add(medicineDetail);
		medicineDetail.setSession(this);

		return medicineDetail;
	}

	public MedicineDetail removeMedicineDetail(MedicineDetail medicineDetail) {
		getMedicineDetails().remove(medicineDetail);
		medicineDetail.setSession(null);

		return medicineDetail;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<SessionDetail> getSessionDetails() {
		return this.sessionDetails;
	}

	public void setSessionDetails(List<SessionDetail> sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	public SessionDetail addSessionDetail(SessionDetail sessionDetail) {
		getSessionDetails().add(sessionDetail);
		sessionDetail.setSession(this);

		return sessionDetail;
	}

	public SessionDetail removeSessionDetail(SessionDetail sessionDetail) {
		getSessionDetails().remove(sessionDetail);
		sessionDetail.setSession(null);

		return sessionDetail;
	}

}