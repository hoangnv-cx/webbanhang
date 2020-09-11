package com.javaweb.service;

import com.javaweb.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserDto add(UserDto userDto);
    void delete(Long[] ids);

    List<UserDto> findAllByOrderByIdDesc();
    List<UserDto> findAllByOrderByIdDesc(Pageable pageable);
    UserDto findOneById(Long id);
    List<UserDto> search(String keyWord);
    int count();
}
