package com.hp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Doctor.class)
public abstract class Doctor_ {

	public static volatile ListAttribute<Doctor, Specialize> specializes;
	public static volatile SingularAttribute<Doctor, String> address;
	public static volatile SingularAttribute<Doctor, String> code;
	public static volatile SingularAttribute<Doctor, String> phoneNumber;
	public static volatile SingularAttribute<Doctor, Date> dob;
	public static volatile ListAttribute<Doctor, SessionDetail> sessionDetails;
	public static volatile SingularAttribute<Doctor, String> description;
	public static volatile SingularAttribute<Doctor, String> id;
	public static volatile SingularAttribute<Doctor, String> fullname;
	public static volatile SingularAttribute<Doctor, String> position;
	public static volatile SingularAttribute<Doctor, String> email;
	public static volatile SingularAttribute<Doctor, Integer> status;

}

