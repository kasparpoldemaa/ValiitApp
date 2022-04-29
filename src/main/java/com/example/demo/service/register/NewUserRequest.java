package com.example.demo.service.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequest implements Serializable {
    private String userName;
    private String password;
    private Integer roleId;
}
