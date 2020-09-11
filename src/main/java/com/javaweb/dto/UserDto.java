package com.javaweb.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto extends BaseDto implements Serializable {


    private String userName;
    private String password;
    private String fullName;
    private List<RoleDto> roleDtos=new ArrayList<>();


    public List<RoleDto> getRoleDtos() {
        return roleDtos;
    }

    public void setRoleDtos(List<RoleDto> roleDtos) {
        this.roleDtos = roleDtos;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
