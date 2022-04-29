package com.example.demo.domain.userrole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequest implements Serializable {
    private String username;
    private String password;
    private Integer roleId;
}
