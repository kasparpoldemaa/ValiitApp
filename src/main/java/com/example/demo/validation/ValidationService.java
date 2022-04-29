package com.example.demo.validation;


import com.example.demo.domain.user.User;
import com.example.demo.infrastructure.exception.BusinessException;
import com.example.demo.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {

    public static final String KASUTAJA_ON_JUBA_OLEMAS = "Sellise kasutajanimega kasutaja on juba olemas.";
    public static final String ANDMED_ON_VALED = "Sisestatud andmed on valed";

    public void userNameExists(boolean userExists, String userName) {
        if (userExists) {
            throw new BusinessException(KASUTAJA_ON_JUBA_OLEMAS,"Kasutajanimi " + userName + " on juba kasutusel");
        }
    }

    public void userExists(String userName, String password, Optional<User> user) {
        if (user.isEmpty()) {
            throw new DataNotFoundException(ANDMED_ON_VALED, "Sisestatud kasutajanimi/parool on vale");
        }
    }
}
