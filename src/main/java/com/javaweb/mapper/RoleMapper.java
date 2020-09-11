package com.javaweb.mapper;

import com.javaweb.dto.RoleDto;
import com.javaweb.dto.UserDto;
import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RoleMapper {
    @Autowired
    private UserMapper userMapper;
    public RoleDto EntityToDto(RoleEntity entity){
        RoleDto dto=new RoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        return  dto;
    }
    public RoleEntity DtoToEntity(RoleDto dto){
        RoleEntity entity=new RoleEntity();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }
    public RoleEntity DtoToEntity(RoleDto dto,RoleEntity entity){
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }
}
