package com.hp.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, Date> passwordChangeDate;
	public static volatile ListAttribute<UserEntity, RoleUserEntity> roleUsers;
	public static volatile SingularAttribute<UserEntity, Integer> enabled;
	public static volatile SingularAttribute<UserEntity, Integer> accountStatus;
	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, Date> createdDate;
	public static volatile SingularAttribute<UserEntity, String> createdBy;
	public static volatile SingularAttribute<UserEntity, Date> modifiedDate;
	public static volatile SingularAttribute<UserEntity, String> modifiedBy;
	public static volatile SingularAttribute<UserEntity, Integer> id;
	public static volatile SingularAttribute<UserEntity, String> fullname;
	public static volatile SingularAttribute<UserEntity, String> email;
	public static volatile SingularAttribute<UserEntity, String> username;

}

