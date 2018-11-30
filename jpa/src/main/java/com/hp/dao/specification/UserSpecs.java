//package com.hp.dao.specification;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.data.jpa.domain.Specification;
//
//import com.hp.entity.UserEntity;
//
//public class UserSpecs {
//public static Specification<UserEntity> getUserEntityByNameSpec(String name){
//	return new Specification<UserEntity>() {
//		public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//		
//			return null;
//		}
//	
//	};
//
//}
//}