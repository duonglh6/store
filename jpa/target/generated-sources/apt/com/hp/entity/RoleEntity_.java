package com.hp.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RoleEntity.class)
public abstract class RoleEntity_ {

	public static volatile SingularAttribute<RoleEntity, String> name;
	public static volatile SingularAttribute<RoleEntity, String> description;
	public static volatile SingularAttribute<RoleEntity, Integer> id;
	public static volatile ListAttribute<RoleEntity, RoleUserEntity> roleUsers;

}

