package com.example.demo.domain.userrole;

import com.example.demo.domain.role.RoleService;
import com.example.demo.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;


    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik userRole-id")
    public List<NewUserRequest> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }





}
