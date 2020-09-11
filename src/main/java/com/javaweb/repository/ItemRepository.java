package com.javaweb.repository;

import com.javaweb.entity.ItemEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    List<ItemEntity> findAllByOrderByIdDesc();
    List<ItemEntity> findAllByOrderByIdDesc(Pageable pageable);
    List<ItemEntity> findAllByTitle(String keyWord);
}
