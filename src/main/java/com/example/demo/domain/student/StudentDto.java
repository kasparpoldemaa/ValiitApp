package com.example.demo.domain.student;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StudentDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    private final String userUserName;
    private final String userPassword;
    private final Integer studentProfileId;
    private final String studentProfileAvailableFrom;
    private final String studentProfileLocation;
    private final LocalDate studentProfileDateOfBirth;
    private final String studentProfileCompetence;
    private final String studentProfileStrength;
    private final String studentProfileAboutMe;
    private final String studentProfileLinkedin;
    private final String studentProfileGithubLink;
    private final Boolean isAvailable;
}
