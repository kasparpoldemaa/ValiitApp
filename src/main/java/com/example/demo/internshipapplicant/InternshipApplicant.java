package com.example.demo.internshipapplicant;

import com.example.demo.internshipopportunity.InternshipOpportunity;
import com.example.demo.student.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "internship_applicant")
public class InternshipApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "internship_opportunity_id", nullable = false)
    private InternshipOpportunity internshipOpportunity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "motivation_letter", nullable = false, length = 1000)
    private String motivationLetter;

}