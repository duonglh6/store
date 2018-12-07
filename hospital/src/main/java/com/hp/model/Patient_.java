package com.hp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Patient.class)
public abstract class Patient_ {

	public static volatile SingularAttribute<Patient, String> note;
	public static volatile ListAttribute<Patient, Session> sessions;
	public static volatile SingularAttribute<Patient, String> address;
	public static volatile SingularAttribute<Patient, String> code;
	public static volatile SingularAttribute<Patient, Byte> gender;
	public static volatile SingularAttribute<Patient, City> city;
	public static volatile SingularAttribute<Patient, Date> createdDate;
	public static volatile SingularAttribute<Patient, String> phoneNumber;
	public static volatile SingularAttribute<Patient, String> createdBy;
	public static volatile SingularAttribute<Patient, Date> dob;
	public static volatile SingularAttribute<Patient, String> id;
	public static volatile SingularAttribute<Patient, String> fullname;
	public static volatile SingularAttribute<Patient, String> email;
	public static volatile SingularAttribute<Patient, Integer> status;

}

