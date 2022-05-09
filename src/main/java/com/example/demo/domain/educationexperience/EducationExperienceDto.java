package com.example.demo.domain.educationexperience;

import com.example.demo.domain.student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationExperienceDto implements Serializable {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String school;
    private String degree;
    private String field;
//    private StudentDto student;
}
