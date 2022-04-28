package com.example.demo.internshipapplicant;

import com.example.demo.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.student.StudentDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class InternshipApplicantDto implements Serializable {
    private final Integer id;
    private final InternshipOpportunityDto internshipOpportunity;
    private final StudentDto student;
    private final String motivationLetter;
}
