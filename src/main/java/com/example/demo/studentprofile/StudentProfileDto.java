package com.example.demo.studentprofile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileDto implements Serializable {
    private Integer id;
    private String availableFrom;
    private String location;
    private LocalDate dateOfBirth;
    private String competence;
    private String strength;
    private String aboutMe;
    private String linkedin;
    private String githubLink;
}
