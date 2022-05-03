package com.example.demo.service.register;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class NewUserResponse {
    private Integer userId;
    private Integer roleId;
    private Integer contactId;
    @Nullable
    private Integer studentProfileId;
    @Nullable
    private Integer studentId;

}
