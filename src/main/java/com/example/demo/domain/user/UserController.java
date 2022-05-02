package com.example.demo.domain.user;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/id")
    @Operation(summary = "Leiab kasutaja userId järgi")
    public UserDto getUserByUserId(Integer userId) {
        return userService.getUserByUserId(userId);

    }

}
