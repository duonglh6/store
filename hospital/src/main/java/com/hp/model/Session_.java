package com.hp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Session.class)
public abstract class Session_ {

	public static volatile SingularAttribute<Session, String> note;
	public static volatile SingularAttribute<Session, String> code;
	public static volatile SingularAttribute<Session, String> diagnosis;
	public static volatile ListAttribute<Session, MedicalTestDetail> medicalTestDetails;
	public static volatile ListAttribute<Session, MedicineDetail> medicineDetails;
	public static volatile SingularAttribute<Session, String> symptom;
	public static volatile SingularAttribute<Session, Date> createdDate;
	public static volatile SingularAttribute<Session, String> createdBy;
	public static volatile SingularAttribute<Session, Patient> patient;
	public static volatile ListAttribute<Session, SessionDetail> sessionDetails;
	public static volatile SingularAttribute<Session, Date> followUpExamination;
	public static volatile SingularAttribute<Session, String> id;
	public static volatile SingularAttribute<Session, Integer> status;

}

