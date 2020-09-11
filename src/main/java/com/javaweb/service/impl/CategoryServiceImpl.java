package com.javaweb.service.impl;

import com.javaweb.dto.CategoryDto;
import com.javaweb.dto.ItemDto;
import com.javaweb.dto.UserDto;
import com.javaweb.entity.CategoryEntity;
import com.javaweb.entity.ItemEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.mapper.CategoryMapper;
import com.javaweb.mapper.ItemMapper;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public CategoryDto add(CategoryDto categoryDto) {
        CategoryEntity categoryEntity=new CategoryEntity();
        if(categoryDto.getId()!=null){
            CategoryEntity categoryEntity1=categoryRepository.getOne(categoryDto.getId());
            categoryEntity= categoryMapper.DtoToEntity(categoryDto,categoryEntity1);
        }else {
            categoryEntity=categoryMapper.DtoToEntity(categoryDto);
        }
        categoryRepository.save(categoryEntity);
        return categoryMapper.EntityToDto(categoryEntity);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            categoryRepository.deleteById(id);
        }
    }

    @Override
    public List<CategoryDto> findAllByOrderByIdDesc() {
        List<CategoryEntity> categoryEntityList=categoryRepository.findAllByOrderByIdDesc();
        List<CategoryDto> categoryDtoList=new ArrayList<>();
        for(CategoryEntity categoryEntity: categoryEntityList){
            CategoryDto categoryDto=new CategoryDto();
            categoryDto=categoryMapper.EntityToDto(categoryEntity);
            List<ItemDto> itemDtoList=new ArrayList<>();
            for(ItemEntity itemEntity:categoryEntity.getItems()){
                ItemDto itemDto=itemMapper.EntityToDto(itemEntity);
                itemDtoList.add(itemDto);

            }
            categoryDto.setItemDtoList(itemDtoList);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public List<CategoryDto> findAllByOrderByIdDesc(Pageable pageable) {
        List<CategoryEntity> categoryEntityList=categoryRepository.findAllByOrderByIdDesc(pageable);
        List<CategoryDto> categoryDtoList=new ArrayList<>();
        for(CategoryEntity categoryEntity: categoryEntityList){
            CategoryDto categoryDto=new CategoryDto();
            categoryDto=categoryMapper.EntityToDto(categoryEntity);
            List<ItemDto> itemDtoList=new ArrayList<>();
            for(ItemEntity itemEntity:categoryEntity.getItems()){
                ItemDto itemDto=itemMapper.EntityToDto(itemEntity);
                itemDtoList.add(itemDto);

            }
            categoryDto.setItemDtoList(itemDtoList);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public CategoryDto findByCode(String code) {
        CategoryEntity categoryEntity=categoryRepository.findByCode(code);
        List<ItemDto> itemDtoList=new ArrayList<>();
        for(ItemEntity itemEntity:categoryEntity.getItems()){
            ItemDto itemDto=itemMapper.EntityToDto(itemEntity);
            itemDtoList.add(itemDto);
        }
        CategoryDto categoryDto=categoryMapper.EntityToDto(categoryEntity);
        categoryDto.setItemDtoList(itemDtoList);
        return categoryDto;
    }

    @Override
    public int count() {
        return (int) categoryRepository.count();
    }
}
