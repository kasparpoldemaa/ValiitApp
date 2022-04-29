package com.example.demo.role;

import com.example.demo.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;



//    @DeleteMapping("/remove")
//    @Operation(summary = "Kustutab rolli id järgi")
//    public void deleteRole(Integer roleId) {
//        roleService.deleteById(roleId);
//    }


}
