package com.javaweb.service.impl;

import com.javaweb.dao.IItemDao;
import com.javaweb.dto.CategoryDto;
import com.javaweb.dto.ItemDto;
import com.javaweb.entity.CategoryEntity;
import com.javaweb.entity.ItemEntity;
import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.mapper.CategoryMapper;
import com.javaweb.mapper.ItemMapper;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.ItemRepository;
import com.javaweb.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private IItemDao itemDao;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ItemDto add(ItemDto itemDto) {
        ItemEntity itemEntity=new ItemEntity();
        if(itemDto.getId()!=null){
            ItemEntity itemEntity1=itemRepository.getOne(itemDto.getId());
            itemEntity=itemMapper.DtoToEntity(itemDto,itemEntity1);
        }else {
            itemEntity=itemMapper.DtoToEntity(itemDto);
        }
        CategoryEntity categoryEntity=categoryRepository.findByCode(itemDto.getCategoryDto().getCode());
        itemEntity.setClassify(categoryEntity);
        itemRepository.save(itemEntity);
        return itemMapper.EntityToDto(itemEntity);
    }

    @Override
    public void delete(Long []ids) {
        for(Long id:ids){
            itemRepository.deleteById(id);
        }
    }

    @Override
    public List<ItemDto> findAllByOrderByIdDesc() {
        List<ItemEntity> itemEntityList=itemRepository.findAllByOrderByIdDesc();
        List<ItemDto> itemDtoList=new ArrayList<>();
        for(ItemEntity itemEntity:itemEntityList){
            ItemDto itemDto=itemMapper.EntityToDto(itemEntity);
            CategoryDto categoryDto=categoryMapper.EntityToDto(itemEntity.getClassify());
            itemDto.setCategoryDto(categoryDto);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }

    @Override
    public List<ItemDto> findAllByOrderByIdDesc(Pageable pageable) {
        List<ItemEntity> itemEntityList=itemRepository.findAllByOrderByIdDesc(pageable);
        List<ItemDto> itemDtoList=new ArrayList<>();
        for(ItemEntity itemEntity:itemEntityList){
            ItemDto itemDto=itemMapper.EntityToDto(itemEntity);
            CategoryDto categoryDto=categoryMapper.EntityToDto(itemEntity.getClassify());
            itemDto.setCategoryDto(categoryDto);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }

    @Override
    public List<ItemDto> search(String keyWord) {
        List<ItemEntity> itemEntityList=itemDao.search(keyWord);
        List<ItemDto> itemDtoList=new ArrayList<>();
        for(ItemEntity itemEntity:itemEntityList){
            ItemDto itemDto=new ItemDto();
            itemDto=itemMapper.EntityToDto(itemEntity);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    @Override
    public ItemDto findById(Long id) {
        ItemEntity itemEntity=itemRepository.getOne(id);
        ItemDto itemDto=itemMapper.EntityToDto(itemEntity);
        itemDto.setCategoryDto(categoryMapper.EntityToDto(itemEntity.getClassify()));
        return itemDto;
    }

    @Override
    public int count() {
        return (int) itemRepository.count();
    }
}
