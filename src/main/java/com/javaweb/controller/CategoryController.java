package com.javaweb.controller;

import com.javaweb.controller.output.CategoryOutput;
import com.javaweb.dto.CategoryDto;
import com.javaweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = "/web/category")
    public CategoryOutput GetCategoryAll(@RequestParam(name = "page",required = false)Integer page,
                                         @RequestParam(name = "limit",required = false)Integer limit){
        CategoryOutput categoryOutput=new CategoryOutput();
        if(page!=null&&limit!=null){
            Pageable pageable= PageRequest.of(page-1,limit);
            categoryOutput.setResults(categoryService.findAllByOrderByIdDesc(pageable));
            categoryOutput.setTotalPage((int) Math.ceil(categoryService.count())/limit);
            categoryOutput.setPage(page);
        }else {
            categoryOutput.setResults(categoryService.findAllByOrderByIdDesc());
        }
        return categoryOutput;
    }

    @GetMapping(value = "/web/category/{code}")
    public CategoryDto GetCategoryByCode(@PathVariable(name = "code")String code){
        return categoryService.findByCode(code);
    }
    @PostMapping(value = "/admin/category")
    public CategoryDto PostCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.add(categoryDto);
    }
    @PutMapping(value = "/admin/category")
    public CategoryDto PutCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.add(categoryDto);
    }
    @DeleteMapping(value = "/admin/category")
    public void DeleteCategory(@RequestBody  Long []ids){
        categoryService.delete(ids);
    }


}
