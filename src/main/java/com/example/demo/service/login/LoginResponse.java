package com.example.demo.service.login;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class LoginResponse {
    private Integer userId;
    private Integer roleId;
    private Integer contactId;
    @Nullable
    private Integer studentProfileId;
    @Nullable
    private Integer studentId;

}
