package com.hp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MedicalTest.class)
public abstract class MedicalTest_ {

	public static volatile SingularAttribute<MedicalTest, String> code;
	public static volatile SingularAttribute<MedicalTest, String> name;
	public static volatile SingularAttribute<MedicalTest, String> id;
	public static volatile ListAttribute<MedicalTest, MedicalTestDetail> medicalTestDetails;

}

