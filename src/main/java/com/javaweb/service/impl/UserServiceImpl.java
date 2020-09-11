package com.javaweb.service.impl;

import com.javaweb.dao.IUserDao;
import com.javaweb.dto.RoleDto;
import com.javaweb.dto.UserDto;
import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.mapper.RoleMapper;
import com.javaweb.mapper.UserMapper;
import com.javaweb.repository.RoleRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public UserDto add(UserDto userDto) {

        UserEntity userEntity=new UserEntity();
        if(userDto.getId()!=null){
            UserEntity userEntity1=userRepository.getOne(userDto.getId());
            userEntity=userMapper.DtoToEntity(userDto,userEntity1);
        }else {
            UserEntity userEntity1=userRepository.findByUserName(userDto.getUserName());
            if(userEntity1!=null){
                return null;
            }else {
                userEntity=userMapper.DtoToEntity(userDto);
            }
        }
        List<RoleEntity> roleEntities=new ArrayList<>();
        for(RoleDto roleDto:userDto.getRoleDtos()){
            RoleEntity roleEntity=roleRepository.findByCode(roleDto.getCode());
            roleEntities.add(roleEntity);
        }
        userEntity.setRoles(roleEntities);
        userRepository.save(userEntity);
        return userMapper.EntityToDto(userEntity);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            userRepository.deleteById(id);
        }
    }

    @Override
    public List<UserDto> findAllByOrderByIdDesc() {

        List<UserEntity> userEntities=userRepository.findAllByOrderByIdDesc();
        List<UserDto> userDtoList=new ArrayList<>();
        for(UserEntity userEntity:userEntities){
            UserDto userDto=new UserDto();
            userDto=userMapper.EntityToDto(userEntity);
            List<RoleDto> roleDtoList=new ArrayList<>();
            for(RoleEntity roleEntity : userEntity.getRoles()){
                RoleDto roleDto=new RoleDto();
                roleDto=roleMapper.EntityToDto(roleEntity);
                roleDtoList.add(roleDto);
            }
            userDto.setRoleDtos(roleDtoList);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public List<UserDto> findAllByOrderByIdDesc(Pageable pageable) {
        List<UserEntity> userEntities=userRepository.findAllByOrderByIdDesc(pageable);
        List<UserDto> userDtoList=new ArrayList<>();

        for(UserEntity userEntity:userEntities){
            UserDto userDto=new UserDto();
            userDto=userMapper.EntityToDto(userEntity);
            List<RoleDto> roleDtoList=new ArrayList<>();
            for(RoleEntity roleEntity : userEntity.getRoles()){
                RoleDto roleDto=new RoleDto();
                roleDto=roleMapper.EntityToDto(roleEntity);
                roleDtoList.add(roleDto);
            }
            userDto.setRoleDtos(roleDtoList);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @Override
    public UserDto findOneById(Long id) {
        UserEntity userEntity=userRepository.getOne(id);
        List<RoleDto>  roleDtoList=new ArrayList<>();
        for(RoleEntity roleEntity: userEntity.getRoles()){
            RoleDto roleDto=roleMapper.EntityToDto(roleEntity);

            roleDtoList.add(roleDto);
        }
        UserDto userDto=userMapper.EntityToDto(userEntity);
        userDto.setRoleDtos(roleDtoList);
        return userDto;
    }
    @Override
    public List<UserDto> search(String keyWord) {
        List<UserEntity> userEntities =userDao.search(keyWord);
        List<UserDto> userDtos=new ArrayList<>();
        for (UserEntity userEntity:userEntities){
            UserDto userDto=new UserDto();
            userDto=userMapper.EntityToDto(userEntity);
            List<RoleDto> roleDtoList=new ArrayList<>();
            for(RoleEntity roleEntity : userEntity.getRoles()){
                RoleDto roleDto=new RoleDto();
                roleDto=roleMapper.EntityToDto(roleEntity);
                roleDtoList.add(roleDto);
            }
            userDto.setRoleDtos(roleDtoList);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public int count() {
        return (int) userRepository.count();
    }
}
