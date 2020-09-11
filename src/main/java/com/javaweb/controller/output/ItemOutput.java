package com.javaweb.controller.output;

import com.javaweb.dto.ItemDto;
import com.javaweb.dto.RoleDto;

import java.util.ArrayList;
import java.util.List;

public class ItemOutput {
    private int page;
    private int totalPage;
    private List<ItemDto> results=new ArrayList<>();

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

    public List<ItemDto> getResults() {
        return results;
    }

    public void setResults(List<ItemDto> results) {
        this.results = results;
    }
}
