package com.example.demo.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final String userName;
    private final String password;
}
