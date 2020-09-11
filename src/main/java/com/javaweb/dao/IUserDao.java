package com.javaweb.dao;

import com.javaweb.entity.UserEntity;

import java.util.List;

public interface IUserDao {

    List<UserEntity> getAll();
    List<UserEntity> search(String keyWord);


}
