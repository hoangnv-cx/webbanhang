package com.javaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDto extends BaseDto{
    private String name;
    private String code;
    private List<UserDto> userDtos=new ArrayList<>();

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
