package com.hp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.customer.RoleRepositoryCustomized;
import com.hp.entity.RoleEntity;
import com.hp.model.RoleDTO;
import com.hp.model.RoleUserCustom;
import com.mysql.jdbc.StringUtils;

@EnableJpaRepositories
@Repository
public class RoleRepositoryImpl implements RoleRepositoryCustomized {

	// private static final String SEARCH_USERENTITY_ENTRIES = "SELECT id, name
	// FROM role r WHERE "
	// + "LOWER(r.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))" +
	// "ORDER BY r.description ASC";

	// private final NamedParameterJdbcTemplate jdbcTemplate;

	@PersistenceContext
	EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<RoleUserCustom> findBySearchTerm(String searchRole, String searchUser) {
		String searchResults = "SELECT  u.username,r.name  FROM UserEntity as u join u.roleUsers ru join ru.role r  WHERE 1=1  ";

		

		if (!StringUtils.isNullOrEmpty(searchRole)) {
			searchResults += " AND r.name LIKE  '%"+ searchRole +"%' ";
		}
		if (!StringUtils.isNullOrEmpty(searchUser)) {
			searchResults += " AND u.username LIKE  '%"+ searchUser +"%' ";
		}
		Query query = entityManager.createQuery(searchResults);
//		if (!StringUtils.isNullOrEmpty(searchRole)) {
//			query.setParameter("searchRole", "%" + searchRole.trim() + "%");
//		}
//		if (!StringUtils.isNullOrEmpty(searchUser)) {
//			query.setParameter("searchUser", "%" + searchUser.trim() + "%");
//		}
		RoleDTO dto = new RoleDTO();
		query.setFirstResult((dto.getPage() - 1) * dto.getMaxPageItem());
		query.setMaxResults(dto.getMaxPageItem());
		List<RoleUserCustom> listResult = new ArrayList<RoleUserCustom>();
		List<Object[]> list = query.getResultList();
		for (Object[] row : list) {
			RoleUserCustom item = new RoleUserCustom();
			item.setRoleName((String) row[0]);
			item.setUserName((String) row[1]);
			listResult.add(item);

		}
		return listResult;
	}

}
