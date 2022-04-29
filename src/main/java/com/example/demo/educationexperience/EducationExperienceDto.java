package com.example.demo.educationexperience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationExperienceDto implements Serializable {
    //private Integer id;
    private Integer studentId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String school;
    private String degree;
    private String field;
}
