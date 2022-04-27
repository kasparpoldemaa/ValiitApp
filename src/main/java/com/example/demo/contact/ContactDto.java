package com.example.demo.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final String address;
    private final Integer userId;
    private final String userUserName;
    private final String userPassword;
}
