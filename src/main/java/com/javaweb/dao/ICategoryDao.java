package com.javaweb.dao;

import com.javaweb.entity.CategoryEntity;

import java.util.List;

public interface ICategoryDao {
    List<CategoryEntity> search(String keyWord);
}
