package com.javaweb.service;

import com.javaweb.dto.RoleDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRoleService {

    RoleDto add(RoleDto roleDto);
    void delete(Long []ids);
    List<RoleDto> findAllByOrderByIdDesc();
    List<RoleDto> findAllByOrderByIdDesc(Pageable pageable);
    RoleDto findOneById(Long id);
    RoleDto findOneByCode(String code);
    int count();
}
