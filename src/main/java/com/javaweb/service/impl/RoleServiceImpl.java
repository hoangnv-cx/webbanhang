package com.javaweb.service.impl;

import com.javaweb.dto.RoleDto;
import com.javaweb.dto.UserDto;
import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.mapper.RoleMapper;
import com.javaweb.mapper.UserMapper;
import com.javaweb.repository.RoleRepository;
import com.javaweb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public RoleDto add(RoleDto roleDto) {
        RoleEntity roleEntity=new RoleEntity();
            if(roleDto.getId()!=null){
                RoleEntity roleEntity1=roleRepository.getOne(roleDto.getId());
                roleEntity=roleMapper.DtoToEntity(roleDto,roleEntity1);
            }else {
                roleEntity=roleMapper.DtoToEntity(roleDto);
            }
         roleRepository.save(roleEntity);
        return roleMapper.EntityToDto(roleEntity);
    }

    @Override
    public void delete(Long []ids) {
        for(Long id:ids){
            roleRepository.deleteById(id);
        }
    }

    @Override
    public List<RoleDto> findAllByOrderByIdDesc() {
        List<RoleEntity> roleEntityList=roleRepository.findAllByOrderByIdDesc();
        List<RoleDto> roleDtos=new ArrayList<>();
        for(RoleEntity roleEntity:roleEntityList){
            RoleDto roleDto=new RoleDto();
            roleDto=roleMapper.EntityToDto(roleEntity);
            List<UserDto> userDtoList=new ArrayList<>();
            for(UserEntity userEntity:roleEntity.getUsers()){
                UserDto userDto=new UserDto();
                userDto=userMapper.EntityToDto(userEntity);
                userDtoList.add(userDto);
            }
            roleDto.setUserDtos(userDtoList);
            roleDtos.add(roleDto);

        }

        return roleDtos;
    }

    @Override
    public List<RoleDto> findAllByOrderByIdDesc(Pageable pageable) {
        List<RoleEntity> roleEntityList=roleRepository.findAllByOrderByIdDesc(pageable);
        List<RoleDto> roleDtos=new ArrayList<>();
        for(RoleEntity roleEntity:roleEntityList){
            RoleDto roleDto=new RoleDto();
            roleDto=roleMapper.EntityToDto(roleEntity);
            List<UserDto> userDtoList=new ArrayList<>();
            for(UserEntity userEntity:roleEntity.getUsers()){
                UserDto userDto=new UserDto();
                userDto=userMapper.EntityToDto(userEntity);
                userDtoList.add(userDto);
            }
            roleDto.setUserDtos(userDtoList);
            roleDtos.add(roleDto);
        }

        return roleDtos;
    }

    @Override
    public RoleDto findOneById(Long id) {
        RoleEntity roleEntity=roleRepository.getOne(id);
        List<UserDto> userDtoList=new ArrayList<>();
        for (UserEntity userEntity:roleEntity.getUsers()){
            UserDto userDto=userMapper.EntityToDto(userEntity);
            userDtoList.add(userDto);
        }
        RoleDto roleDto=roleMapper.EntityToDto(roleEntity);
        roleDto.setUserDtos(userDtoList);
        return roleDto;
    }

    @Override
    public RoleDto findOneByCode(String code) {
        RoleEntity roleEntity=roleRepository.findByCode(code);
        List<UserDto> userDtoList=new ArrayList<>();
        for (UserEntity userEntity:roleEntity.getUsers()){
            UserDto userDto=userMapper.EntityToDto(userEntity);
            userDtoList.add(userDto);
        }
        RoleDto roleDto=roleMapper.EntityToDto(roleEntity);
        roleDto.setUserDtos(userDtoList);
        return roleDto;
    }

    @Override
    public int count() {
        return (int) roleRepository.count();
    }
}
