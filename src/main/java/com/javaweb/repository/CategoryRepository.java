package com.javaweb.repository;

import com.javaweb.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    List<CategoryEntity> findAllByOrderByIdDesc();
    List<CategoryEntity> findAllByOrderByIdDesc(Pageable pageable);
    CategoryEntity findByCode(String code);
}
