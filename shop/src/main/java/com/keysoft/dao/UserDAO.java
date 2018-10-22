package com.keysoft.dao;

import java.util.List;

import com.keysoft.entity.UserEntity;

public interface UserDAO {
public void addUser(UserEntity user);
public void updateUser(UserEntity user);
public void deleteUser(int id);
public UserEntity getUserById(int id);
public List<UserEntity> getAllUser();
}
