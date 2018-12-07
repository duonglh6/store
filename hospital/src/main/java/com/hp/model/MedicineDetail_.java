package com.hp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MedicineDetail.class)
public abstract class MedicineDetail_ {

	public static volatile SingularAttribute<MedicineDetail, String> dosage;
	public static volatile SingularAttribute<MedicineDetail, Integer> amount;
	public static volatile SingularAttribute<MedicineDetail, String> unit;
	public static volatile SingularAttribute<MedicineDetail, String> notes;
	public static volatile SingularAttribute<MedicineDetail, Session> session;
	public static volatile SingularAttribute<MedicineDetail, Medicine> medicine;
	public static volatile SingularAttribute<MedicineDetail, String> id;

}

