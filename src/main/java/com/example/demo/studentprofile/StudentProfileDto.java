package com.example.demo.studentprofile;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StudentProfileDto implements Serializable {
    private final Integer id;
    private final String availableFrom;
    private final String location;
    private final LocalDate dateOfBirth;
    private final String competence;
    private final String strength;
    private final String aboutMe;
    private final String linkedin;
    private final String githubLink;
}
