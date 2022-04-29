package com.example.demo.domain.internshipapplicant;

import com.example.demo.domain.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.domain.student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipApplicantDto implements Serializable {
    private Integer id;
    private InternshipOpportunityDto internshipOpportunity;
    private StudentDto student;
    private String motivationLetter;
}
