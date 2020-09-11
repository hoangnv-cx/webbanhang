package com.javaweb.repository;

import com.javaweb.entity.RoleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByCode(String code);
    List<RoleEntity> findAllByOrderByIdDesc();
    List<RoleEntity> findAllByOrderByIdDesc(Pageable pageable);
}
