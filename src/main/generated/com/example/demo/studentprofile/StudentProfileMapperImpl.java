package com.example.demo.studentprofile;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T14:47:53+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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

        StudentProfileDto studentProfileDto = new StudentProfileDto();

        studentProfileDto.setId( studentProfile.getId() );
        studentProfileDto.setAvailableFrom( studentProfile.getAvailableFrom() );
        studentProfileDto.setLocation( studentProfile.getLocation() );
        studentProfileDto.setDateOfBirth( studentProfile.getDateOfBirth() );
        studentProfileDto.setCompetence( studentProfile.getCompetence() );
        studentProfileDto.setStrength( studentProfile.getStrength() );
        studentProfileDto.setAboutMe( studentProfile.getAboutMe() );
        studentProfileDto.setLinkedin( studentProfile.getLinkedin() );
        studentProfileDto.setGithubLink( studentProfile.getGithubLink() );

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
