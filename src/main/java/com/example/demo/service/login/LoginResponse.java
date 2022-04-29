package com.example.demo.service.login;

import com.example.demo.domain.userrole.NewUserRequest;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private Integer userId;
    private String userName;
    private String password;
    private List<NewUserRequest> roles;

}
