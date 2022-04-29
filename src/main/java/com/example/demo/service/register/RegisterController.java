package com.example.demo.service.register;

import com.example.demo.domain.userrole.NewUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class RegisterController {
    private RegisterService registerService;

    @PostMapping("/new")
    @Operation(summary = "Lisab uue kasutaja ja lisab uuele kasutajale rolli")
    public NewUserResponse addNewUser(@Valid @RequestBody NewUserRequest request) {
        return registerService.addNewUser(request);
    }

}
