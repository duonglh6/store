package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medicine_detail database table.
 * 
 */
@Entity
@Table(name="medicine_detail")
@NamedQuery(name="MedicineDetail.findAll", query="SELECT m FROM MedicineDetail m")
public class MedicineDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int amount;

	private String dosage;

	private String notes;

	private String unit;

	//bi-directional many-to-one association to Medicine
	@ManyToOne
	private Medicine medicine;

	//bi-directional many-to-one association to Session
	@ManyToOne
	private Session session;

	public MedicineDetail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDosage() {
		return this.dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Medicine getMedicine() {
		return this.medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}