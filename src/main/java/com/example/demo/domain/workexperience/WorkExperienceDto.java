package com.example.demo.domain.workexperience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto implements Serializable {
    //private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String companyName;
    private String position;
    private String jobDescription;
    //private StudentDto student;


}
