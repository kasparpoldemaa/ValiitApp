package com.example.demo.domain.userrole;

import com.example.demo.domain.role.RoleService;
import com.example.demo.domain.user.UserService;
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
    @Operation(summary = "Lisab uue kasutaja ja lisab uuele kasutajale rolli")
    public UserRoleDto addNewUserAndSetRole(@Valid @RequestBody UserRoleDto userRoleDto, @RequestParam String roleName) {
        return userRoleService.addNewUserAndSetRole(userRoleDto, roleName);
    }



}
