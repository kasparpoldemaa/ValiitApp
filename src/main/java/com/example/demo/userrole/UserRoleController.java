package com.example.demo.userrole;

import com.example.demo.role.RoleService;
import com.example.demo.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    public List<UserRoleDto> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @PostMapping("/new")
    @Operation(summary = "Lisab uue role-i ja useri-i")
    public UserRoleDto addNewUserAndRole(@Valid @RequestBody UserRoleDto userRoleDto) {
        return userRoleService.addNewUserAndRole(userRoleDto);
    }

}
