package com.example.demo.service.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequest implements Serializable {
    @NotNull
    private Integer roleId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String companyName;
    private String address;

}
