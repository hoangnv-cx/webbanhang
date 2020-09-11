package com.javaweb.service;

import com.javaweb.dto.CategoryDto;
import com.javaweb.dto.ItemDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    CategoryDto add(CategoryDto categoryDto);
    void delete(Long []ids);
    List<CategoryDto> findAllByOrderByIdDesc();
    List<CategoryDto> findAllByOrderByIdDesc(Pageable pageable);
    CategoryDto findByCode(String code);
    int count();
}
