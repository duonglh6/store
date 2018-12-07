package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the specialize database table.
 * 
 */
@Entity
@NamedQuery(name="Specialize.findAll", query="SELECT s FROM Specialize s")
public class Specialize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String description;

	private String name;

	//bi-directional many-to-many association to Doctor
	@ManyToMany
	@JoinTable(
		name="doctor_and_specialize"
		, joinColumns={
			@JoinColumn(name="specialize_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="doctor_id")
			}
		)
	private List<Doctor> doctors;

	public Specialize() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}