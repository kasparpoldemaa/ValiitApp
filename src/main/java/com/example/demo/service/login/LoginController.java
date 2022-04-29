package com.example.demo.service.login;

import com.example.demo.service.login.LoginResponse;
import com.example.demo.service.login.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;
//    @GetMapping("/in")
//    public LoginResponse logIn(@RequestParam String userName, @RequestParam String password ) {
//        LoginResponse response = loginService.logIn(userName, password);
//        return response;
//    }








}
