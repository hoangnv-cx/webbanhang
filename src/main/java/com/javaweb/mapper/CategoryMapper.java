package com.javaweb.mapper;

import com.javaweb.dto.CategoryDto;
import com.javaweb.dto.ItemDto;
import com.javaweb.entity.CategoryEntity;
import com.javaweb.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    @Autowired
    private ItemMapper itemMapper;
    public CategoryDto EntityToDto(CategoryEntity entity){
        CategoryDto dto=new CategoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        return dto;
    }
    public CategoryEntity DtoToEntity(CategoryDto dto){
        CategoryEntity entity=new CategoryEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }
    public CategoryEntity DtoToEntity(CategoryDto dto,CategoryEntity entity){
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }
}
