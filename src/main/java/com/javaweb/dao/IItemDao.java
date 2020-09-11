package com.javaweb.dao;

import com.javaweb.entity.ItemEntity;

import java.util.List;

public interface IItemDao {

    List<ItemEntity> search(String keyWord);
}
