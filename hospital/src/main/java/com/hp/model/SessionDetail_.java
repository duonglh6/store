package com.hp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SessionDetail.class)
public abstract class SessionDetail_ {

	public static volatile SingularAttribute<SessionDetail, Doctor> doctor;
	public static volatile SingularAttribute<SessionDetail, String> reason;
	public static volatile SingularAttribute<SessionDetail, String> createdBy;
	public static volatile SingularAttribute<SessionDetail, Session> session;
	public static volatile SingularAttribute<SessionDetail, Date> createdTime;
	public static volatile SingularAttribute<SessionDetail, Date> workingTime;
	public static volatile SingularAttribute<SessionDetail, String> id;
	public static volatile SingularAttribute<SessionDetail, String> urlResult;

}

