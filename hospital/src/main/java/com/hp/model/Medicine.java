package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicine database table.
 * 
 */
@Entity
@NamedQuery(name="Medicine.findAll", query="SELECT m FROM Medicine m")
public class Medicine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="active_ingredient")
	private String activeIngredient;

	@Column(name="patent_medicine")
	private String patentMedicine;

	//bi-directional many-to-one association to MedicineDetail
	@OneToMany(mappedBy="medicine")
	private List<MedicineDetail> medicineDetails;

	public Medicine() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActiveIngredient() {
		return this.activeIngredient;
	}

	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	public String getPatentMedicine() {
		return this.patentMedicine;
	}

	public void setPatentMedicine(String patentMedicine) {
		this.patentMedicine = patentMedicine;
	}

	public List<MedicineDetail> getMedicineDetails() {
		return this.medicineDetails;
	}

	public void setMedicineDetails(List<MedicineDetail> medicineDetails) {
		this.medicineDetails = medicineDetails;
	}

	public MedicineDetail addMedicineDetail(MedicineDetail medicineDetail) {
		getMedicineDetails().add(medicineDetail);
		medicineDetail.setMedicine(this);

		return medicineDetail;
	}

	public MedicineDetail removeMedicineDetail(MedicineDetail medicineDetail) {
		getMedicineDetails().remove(medicineDetail);
		medicineDetail.setMedicine(null);

		return medicineDetail;
	}

}