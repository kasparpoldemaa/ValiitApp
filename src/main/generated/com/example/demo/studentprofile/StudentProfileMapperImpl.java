package com.example.demo.studentprofile;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-27T15:47:28+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class StudentProfileMapperImpl implements StudentProfileMapper {

    @Override
    public StudentProfile toEntity(StudentProfileDto studentProfileDto) {
        if ( studentProfileDto == null ) {
            return null;
        }

        StudentProfile studentProfile = new StudentProfile();

        studentProfile.setId( studentProfileDto.getId() );
        studentProfile.setAvailableFrom( studentProfileDto.getAvailableFrom() );
        studentProfile.setLocation( studentProfileDto.getLocation() );
        studentProfile.setDateOfBirth( studentProfileDto.getDateOfBirth() );
        studentProfile.setCompetence( studentProfileDto.getCompetence() );
        studentProfile.setStrength( studentProfileDto.getStrength() );
        studentProfile.setAboutMe( studentProfileDto.getAboutMe() );
        studentProfile.setLinkedin( studentProfileDto.getLinkedin() );
        studentProfile.setGithubLink( studentProfileDto.getGithubLink() );

        return studentProfile;
    }

    @Override
    public StudentProfileDto toDto(StudentProfile studentProfile) {
        if ( studentProfile == null ) {
            return null;
        }

        Integer id = null;
        String availableFrom = null;
        String location = null;
        LocalDate dateOfBirth = null;
        String competence = null;
        String strength = null;
        String aboutMe = null;
        String linkedin = null;
        String githubLink = null;

        id = studentProfile.getId();
        availableFrom = studentProfile.getAvailableFrom();
        location = studentProfile.getLocation();
        dateOfBirth = studentProfile.getDateOfBirth();
        competence = studentProfile.getCompetence();
        strength = studentProfile.getStrength();
        aboutMe = studentProfile.getAboutMe();
        linkedin = studentProfile.getLinkedin();
        githubLink = studentProfile.getGithubLink();

        StudentProfileDto studentProfileDto = new StudentProfileDto( id, availableFrom, location, dateOfBirth, competence, strength, aboutMe, linkedin, githubLink );

        return studentProfileDto;
    }

    @Override
    public void updateStudentProfileFromStudentProfileDto(StudentProfileDto studentProfileDto, StudentProfile studentProfile) {
        if ( studentProfileDto == null ) {
            return;
        }

        if ( studentProfileDto.getId() != null ) {
            studentProfile.setId( studentProfileDto.getId() );
        }
        if ( studentProfileDto.getAvailableFrom() != null ) {
            studentProfile.setAvailableFrom( studentProfileDto.getAvailableFrom() );
        }
        if ( studentProfileDto.getLocation() != null ) {
            studentProfile.setLocation( studentProfileDto.getLocation() );
        }
        if ( studentProfileDto.getDateOfBirth() != null ) {
            studentProfile.setDateOfBirth( studentProfileDto.getDateOfBirth() );
        }
        if ( studentProfileDto.getCompetence() != null ) {
            studentProfile.setCompetence( studentProfileDto.getCompetence() );
        }
        if ( studentProfileDto.getStrength() != null ) {
            studentProfile.setStrength( studentProfileDto.getStrength() );
        }
        if ( studentProfileDto.getAboutMe() != null ) {
            studentProfile.setAboutMe( studentProfileDto.getAboutMe() );
        }
        if ( studentProfileDto.getLinkedin() != null ) {
            studentProfile.setLinkedin( studentProfileDto.getLinkedin() );
        }
        if ( studentProfileDto.getGithubLink() != null ) {
            studentProfile.setGithubLink( studentProfileDto.getGithubLink() );
        }
    }
}
