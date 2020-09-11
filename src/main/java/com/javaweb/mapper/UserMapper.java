package com.javaweb.mapper;

import com.javaweb.dto.UserDto;
import com.javaweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserDto EntityToDto(UserEntity userEntity){
        UserDto userDto=new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setFullName(userEntity.getFullName());
        return userDto;
    }
    public UserEntity DtoToEntity(UserDto userDto){
        UserEntity userEntity=new UserEntity();
        userEntity.setUserName(userDto.getUserName());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setFullName(userDto.getFullName());


        return userEntity;
    }
    public UserEntity DtoToEntity(UserDto userDto,UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setFullName(userDto.getFullName());


        return userEntity;
    }

}
