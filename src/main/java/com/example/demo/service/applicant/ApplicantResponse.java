package com.example.demo.service.applicant;

import com.example.demo.domain.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.domain.student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantResponse {
    private Integer id;
    private InternshipOpportunityDto internshipOpportunity;
    private StudentDto student;
    private String motivationLetter;

}
