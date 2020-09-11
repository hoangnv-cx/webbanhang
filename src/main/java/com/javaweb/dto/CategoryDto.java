package com.javaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto extends BaseDto {
    private String name;
    private String code;
    private String image;
    List<ItemDto> itemDtoList=new ArrayList<>();


    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }

    public void setItemDtoList(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
