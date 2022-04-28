package com.example.demo.picture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureDto implements Serializable {
    private Integer id;
    private Integer studentId;
    private Integer studentUserId;
    private String studentUserUserName;
    private String studentUserPassword;
    private Integer studentStudentProfileId;
    private String studentStudentProfileAvailableFrom;
    private String studentStudentProfileLocation;
    private LocalDate studentStudentProfileDateOfBirth;
    private String studentStudentProfileCompetence;
    private String studentStudentProfileStrength;
    private String studentStudentProfileAboutMe;
    private String studentStudentProfileLinkedin;
    private String studentStudentProfileGithubLink;
    private Boolean studentIsAvailable;
    private byte[] base64;
}
