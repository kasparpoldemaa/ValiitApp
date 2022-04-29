package com.example.demo.domain.studentprofile;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student_profile")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "available_from", nullable = false)
    private String availableFrom;

    @Column(name = "location", nullable = false, length = 50)
    private String location;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "competence", nullable = false, length = 500)
    private String competence;

    @Column(name = "strength", nullable = false, length = 500)
    private String strength;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "linkedin", length = 50)
    private String linkedin;

    @Column(name = "github_link", length = 50)
    private String githubLink;

}