package com.hp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MedicalTestDetail.class)
public abstract class MedicalTestDetail_ {

	public static volatile SingularAttribute<MedicalTestDetail, String> laboratory_technician;
	public static volatile SingularAttribute<MedicalTestDetail, Date> createdDate;
	public static volatile SingularAttribute<MedicalTestDetail, String> createdBy;
	public static volatile SingularAttribute<MedicalTestDetail, Session> session;
	public static volatile SingularAttribute<MedicalTestDetail, Date> workingTime;
	public static volatile SingularAttribute<MedicalTestDetail, MedicalTest> medicalTest;
	public static volatile SingularAttribute<MedicalTestDetail, String> id;
	public static volatile SingularAttribute<MedicalTestDetail, String> urlResult;

}

