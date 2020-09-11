package com.javaweb.service;

import com.javaweb.dto.ItemDto;
import com.javaweb.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IItemService {
    ItemDto add(ItemDto itemDto);
    void delete(Long []ids);
    List<ItemDto> findAllByOrderByIdDesc();
    List<ItemDto> findAllByOrderByIdDesc(Pageable pageable);
    List<ItemDto> search(String keyWord);
    ItemDto findById(Long id);
    int count();

}
