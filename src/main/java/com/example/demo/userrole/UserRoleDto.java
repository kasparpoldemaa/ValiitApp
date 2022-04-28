package com.example.demo.userrole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto implements Serializable {
    private Integer id;
    private Integer userId;
    private String userUserName;
    private String userPassword;
    private Integer roleId;
    private String roleName;
}
