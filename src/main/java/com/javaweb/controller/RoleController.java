package com.javaweb.controller;

import com.javaweb.controller.output.RoleOutput;
import com.javaweb.dto.RoleDto;
import com.javaweb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @GetMapping(value = "/role")
    public RoleOutput getRoleAll(@RequestParam(name = "page",required = false)Integer page,
                              @RequestParam(name = "limit",required = false)Integer limit){
        RoleOutput roleOutput=new RoleOutput();
        if(page!=null&&limit!=null){
            Pageable pageable= PageRequest.of(page-1,limit);
            roleOutput.setResults(roleService.findAllByOrderByIdDesc(pageable));
            roleOutput.setTotalPage((int) Math.ceil(roleService.count())/limit);
            roleOutput.setPage(page);
        }else {
            roleOutput.setResults(roleService.findAllByOrderByIdDesc());
        }
        return roleOutput;
    }
    @GetMapping(value = "/role/{id}")
    public RoleDto GetRoleById(@PathVariable(name = "id")Long id){
        return roleService.findOneById(id);
    }
    @GetMapping(value = "/role/code/{code}")
    public RoleDto GetRoleByCode(@PathVariable(name = "code")String code){
        return roleService.findOneByCode(code);
    }
    @PostMapping(value = "/role")
    public RoleDto PostRole(@RequestBody RoleDto roleDto){
        return roleService.add(roleDto);
    }
    @PutMapping(value = "/role")
    public RoleDto PutRole(@RequestBody RoleDto roleDto){
        return roleService.add(roleDto);
    }
    @DeleteMapping(value = "/role")
    public void DeleteRole(@RequestBody Long []ids){
        roleService.delete(ids);
    }
}
