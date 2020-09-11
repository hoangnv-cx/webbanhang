package com.javaweb.controller.output;

import com.javaweb.dto.CategoryDto;
import com.javaweb.dto.RoleDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryOutput {
    private int page;
    private int totalPage;
    private List<CategoryDto> results=new ArrayList<>();

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

    public List<CategoryDto> getResults() {
        return results;
    }

    public void setResults(List<CategoryDto> results) {
        this.results = results;
    }
}
