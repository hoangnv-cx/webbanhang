package com.javaweb.controller.output;

import com.javaweb.dto.RoleDto;
import com.javaweb.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class RoleOutput {
    private int page;
    private int totalPage;
    private List<RoleDto> results=new ArrayList<>();

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

    public List<RoleDto> getResults() {
        return results;
    }

    public void setResults(List<RoleDto> results) {
        this.results = results;
    }
}
