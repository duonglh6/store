package com.hp.dao;

import com.hp.entity.UserEntity;

public interface UserDAO extends BaseRepository<UserEntity, Integer> {
    UserEntity findOneById(Integer id);
}
