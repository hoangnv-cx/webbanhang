package com.javaweb.controller;

import com.javaweb.controller.output.ItemOutput;
import com.javaweb.dto.ItemDto;
import com.javaweb.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ItemController {

    @Autowired
    private IItemService itemService;
    @GetMapping(value = "/web/item")
    public ItemOutput GetItemAll(@RequestParam(name = "page",required = false)Integer page,
                                    @RequestParam(name = "limit",required = false)Integer limit){
        ItemOutput itemOutput=new ItemOutput();
        if(page!=null&&limit!=null){
            Pageable pageable= PageRequest.of(page-1,limit);
            itemOutput.setResults(itemService.findAllByOrderByIdDesc(pageable));
            itemOutput.setTotalPage((int) Math.ceil(itemService.count())/limit);
            itemOutput.setPage(page);
        }else {
            itemOutput.setResults(itemService.findAllByOrderByIdDesc());
        }
        return itemOutput;
    }
    @GetMapping(value = "/web/item/search/{keyword}")
    public List<ItemDto> GetItemSearch(@RequestParam(name = "keyword")String keyWord){
        return itemService.search(keyWord);
    }
    @GetMapping(value = "/web/item/{id}")
    public ItemDto GetItemSearch(@PathVariable(name = "id")Long id){
        return itemService.findById(id);
    }
    @PostMapping(value = "/admin/item")
    public ItemDto PostItem(@RequestBody ItemDto itemDto){
        return itemService.add(itemDto);
    }
    @PutMapping(value = "/admin/item")
    public ItemDto PutItem(@RequestBody ItemDto itemDto){
        return itemService.add(itemDto);
    }
    @DeleteMapping(value = "/admin/item")
    public void DeleteItem(@RequestBody Long[]ids){
        itemService.delete(ids);
    }

}
