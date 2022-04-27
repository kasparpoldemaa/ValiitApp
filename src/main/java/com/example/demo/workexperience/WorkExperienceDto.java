package com.example.demo.workexperience;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class WorkExperienceDto implements Serializable {
    private final Integer id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String companyName;
    private final String position;
    private final String jobDescription;
    private final Integer studentId;
    private final Integer studentUserId;
    private final String studentUserUserName;
    private final String studentUserPassword;
    private final Integer studentStudentProfileId;
    private final String studentStudentProfileAvailableFrom;
    private final String studentStudentProfileLocation;
    private final LocalDate studentStudentProfileDateOfBirth;
    private final String studentStudentProfileCompetence;
    private final String studentStudentProfileStrength;
    private final String studentStudentProfileAboutMe;
    private final String studentStudentProfileLinkedin;
    private final String studentStudentProfileGithubLink;
    private final Boolean studentIsAvailable;
}
