package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medical_tests database table.
 * 
 */
@Entity
@Table(name="medical_tests")
@NamedQuery(name="MedicalTest.findAll", query="SELECT m FROM MedicalTest m")
public class MedicalTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String code;

	private String name;

	//bi-directional many-to-one association to MedicalTestDetail
	@OneToMany(mappedBy="medicalTest")
	private List<MedicalTestDetail> medicalTestDetails;

	public MedicalTest() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MedicalTestDetail> getMedicalTestDetails() {
		return this.medicalTestDetails;
	}

	public void setMedicalTestDetails(List<MedicalTestDetail> medicalTestDetails) {
		this.medicalTestDetails = medicalTestDetails;
	}

	public MedicalTestDetail addMedicalTestDetail(MedicalTestDetail medicalTestDetail) {
		getMedicalTestDetails().add(medicalTestDetail);
		medicalTestDetail.setMedicalTest(this);

		return medicalTestDetail;
	}

	public MedicalTestDetail removeMedicalTestDetail(MedicalTestDetail medicalTestDetail) {
		getMedicalTestDetails().remove(medicalTestDetail);
		medicalTestDetail.setMedicalTest(null);

		return medicalTestDetail;
	}

}