package com.example.demo.validation;


import com.example.demo.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public static final String KASUTAJA_ON_JUBA_OLEMAS = "Sellise kasutajanimega kasutaja on juba olemas.";

    public void userNameExists(boolean userExists, String userName) {
        if (userExists) {
            throw new BusinessException(KASUTAJA_ON_JUBA_OLEMAS,"Kasutajanimi " + userName + " on juba kasutusel");
        }
    }
}
