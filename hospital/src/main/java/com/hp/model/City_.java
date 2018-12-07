package com.hp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(City.class)
public abstract class City_ {

	public static volatile SingularAttribute<City, String> code;
	public static volatile ListAttribute<City, Patient> patients;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, String> id;

}

