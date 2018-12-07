package com.hp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medicine.class)
public abstract class Medicine_ {

	public static volatile SingularAttribute<Medicine, String> patentMedicine;
	public static volatile ListAttribute<Medicine, MedicineDetail> medicineDetails;
	public static volatile SingularAttribute<Medicine, String> activeIngredient;
	public static volatile SingularAttribute<Medicine, String> id;

}

