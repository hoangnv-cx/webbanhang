package com.javaweb.repository;

import com.javaweb.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserName(String name);

    List<UserEntity> findAllByOrderByIdDesc();
    List<UserEntity> findAllByOrderByIdDesc(Pageable pageable);


}
