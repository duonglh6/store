package com.hp.model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Attachment.class)
public abstract class Attachment_ {

	public static volatile SingularAttribute<Attachment, String> fileName;
	public static volatile SingularAttribute<Attachment, String> moduleType;
	public static volatile SingularAttribute<Attachment, String> name;
	public static volatile SingularAttribute<Attachment, String> absolutePath;
	public static volatile SingularAttribute<Attachment, String> id;
	public static volatile SingularAttribute<Attachment, String> functionType;
	public static volatile SingularAttribute<Attachment, BigInteger> moduleId;
	public static volatile SingularAttribute<Attachment, Integer> version;
	public static volatile SingularAttribute<Attachment, String> fileType;
	public static volatile SingularAttribute<Attachment, String> url;

}

