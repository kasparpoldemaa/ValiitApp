package com.example.demo.userrole;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;
}
