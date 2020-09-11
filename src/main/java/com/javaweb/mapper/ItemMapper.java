package com.javaweb.mapper;

import com.javaweb.dto.CategoryDto;
import com.javaweb.dto.ItemDto;
import com.javaweb.dto.UserDto;
import com.javaweb.entity.ItemEntity;
import com.javaweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    @Autowired
    private CategoryMapper categoryMapper;
    public ItemDto EntityToDto(ItemEntity entity){
        ItemDto dto=new ItemDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setThumbnail(entity.getThumbnail());
        dto.setShortDescription(entity.getShortDescription());
        dto.setContent(entity.getContent());
        dto.setCount(entity.getCount());
        return dto;
    }
    public ItemEntity DtoToEntity(ItemDto dto){
        ItemEntity entity=new ItemEntity();
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setThumbnail(dto.getThumbnail());
        entity.setShortDescription(dto.getShortDescription());
        entity.setContent(dto.getContent());
        entity.setCount(dto.getCount());
        return entity;
    }
    public ItemEntity DtoToEntity(ItemDto dto,ItemEntity entity){
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setThumbnail(dto.getThumbnail());
        entity.setShortDescription(dto.getShortDescription());
        entity.setContent(dto.getContent());
        entity.setCount(dto.getCount());
        return entity;
    }
}
