package com.example.demo.service.applicant;

import com.example.demo.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternshipOppurtunityResponse {

    private List<Integer> studentId;
    private Integer studentCount;
}
