package com.javaweb.controller;

import com.javaweb.controller.output.UserOutput;
import com.javaweb.dto.UserDto;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class UserController {
    @Autowired
    private IUserService userService;



    @GetMapping(value = "/user/search/{keyword}")
    public UserOutput search(@PathVariable(value = "keyword",required = false)String keyWord){
        UserOutput resault=new UserOutput();
        resault.setUserDtos(userService.search(keyWord));
        return resault;
    }
    @GetMapping(value = "/user")
    public UserOutput GetData(@RequestParam(value = "page",required = false)Integer page,
                              @RequestParam(value = "limit",required = false)Integer limit){
        UserOutput resault=new UserOutput();
        if(page!=null&&limit!=null){
            Pageable pageable= PageRequest.of(page-1,limit);
            resault.setUserDtos(userService.findAllByOrderByIdDesc(pageable));
            resault.setTotalPage((int) Math.ceil(userService.count())/limit);
            resault.setPage(page);
        }else {
            resault.setUserDtos(userService.findAllByOrderByIdDesc());
        }
        return resault;
    }
    @GetMapping(value = "user/id/{id}")
    public UserDto getDataBId(@PathVariable(name = "id")Long id){

        return userService.findOneById(id);
    }

    @PostMapping(value = "/user")
    public UserDto PostData(@RequestBody UserDto userDto){
        return userService.add(userDto);
    }
    @PutMapping(value = "/user")
    public UserDto PutData(@RequestBody UserDto userDto){
        return userService.add(userDto);
    }
    @DeleteMapping(value = "/user")
    public void DeleteData(@RequestBody Long []ids){
        userService.delete(ids);
    }
}
