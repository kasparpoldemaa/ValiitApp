package com.example.demo.domain.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String address;
    private Integer userId;
    private String userUserName;
    private String userPassword;
}
