package com.javaweb.controller.output;

import com.javaweb.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserOutput {
    private int page;
    private int totalPage;
    private List<UserDto> userDtos=new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }
}
