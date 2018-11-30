package com.hp.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RoleUserEntity.class)
public abstract class RoleUserEntity_ {

	public static volatile SingularAttribute<RoleUserEntity, RoleEntity> role;
	public static volatile SingularAttribute<RoleUserEntity, Integer> id;
	public static volatile SingularAttribute<RoleUserEntity, UserEntity> user;

}

