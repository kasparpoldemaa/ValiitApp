package com.example.demo.domain.role;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;


    @GetMapping("/all")
    public List<RoleDto> getAllRoles () {
        return roleService.getAllRoles();
    }

//    @GetMapping("/name")
//    public Integer getRoleIdByName(String name) {
//        return roleService.getRoleIdbyName(name);
//    }



//    @DeleteMapping("/remove")
//    @Operation(summary = "Kustutab rolli id järgi")
//    public void deleteRole(Integer roleId) {
//        roleService.deleteById(roleId);
//    }


}
