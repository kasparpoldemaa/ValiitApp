package com.example.demo.service.register;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @PostMapping("/new")
    @Operation(summary = "Lisab uue kasutaja ja lisab uuele kasutajale rolli")
    public NewUserResponse addNewUser(@Valid @RequestBody NewUserRequest request) {
        return registerService.addNewUser(request);
    }

}
