package com.example.demo.internshipapplicant;

import com.example.demo.internshipopportunity.InternshipOpportunity;
import com.example.demo.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.student.Student;
import com.example.demo.student.StudentDto;
import com.example.demo.user.User;
import com.example.demo.user.UserDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-29T09:42:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class InternshipApplicantMapperImpl implements InternshipApplicantMapper {

    @Override
    public InternshipApplicant toEntity(InternshipApplicantDto internshipApplicantDto) {
        if ( internshipApplicantDto == null ) {
            return null;
        }

        InternshipApplicant internshipApplicant = new InternshipApplicant();

        internshipApplicant.setId( internshipApplicantDto.getId() );
        internshipApplicant.setInternshipOpportunity( internshipOpportunityDtoToInternshipOpportunity( internshipApplicantDto.getInternshipOpportunity() ) );
        internshipApplicant.setStudent( studentDtoToStudent( internshipApplicantDto.getStudent() ) );
        internshipApplicant.setMotivationLetter( internshipApplicantDto.getMotivationLetter() );

        return internshipApplicant;
    }

    @Override
    public InternshipApplicantDto toDto(InternshipApplicant internshipApplicant) {
        if ( internshipApplicant == null ) {
            return null;
        }

        InternshipApplicantDto internshipApplicantDto = new InternshipApplicantDto();

        internshipApplicantDto.setId( internshipApplicant.getId() );
        internshipApplicantDto.setInternshipOpportunity( internshipOpportunityToInternshipOpportunityDto( internshipApplicant.getInternshipOpportunity() ) );
        internshipApplicantDto.setStudent( studentToStudentDto( internshipApplicant.getStudent() ) );
        internshipApplicantDto.setMotivationLetter( internshipApplicant.getMotivationLetter() );

        return internshipApplicantDto;
    }

    @Override
    public void updateInternshipApplicantFromInternshipApplicantDto(InternshipApplicantDto internshipApplicantDto, InternshipApplicant internshipApplicant) {
        if ( internshipApplicantDto == null ) {
            return;
        }

        if ( internshipApplicantDto.getId() != null ) {
            internshipApplicant.setId( internshipApplicantDto.getId() );
        }
        if ( internshipApplicantDto.getInternshipOpportunity() != null ) {
            if ( internshipApplicant.getInternshipOpportunity() == null ) {
                internshipApplicant.setInternshipOpportunity( new InternshipOpportunity() );
            }
            internshipOpportunityDtoToInternshipOpportunity1( internshipApplicantDto.getInternshipOpportunity(), internshipApplicant.getInternshipOpportunity() );
        }
        if ( internshipApplicantDto.getStudent() != null ) {
            if ( internshipApplicant.getStudent() == null ) {
                internshipApplicant.setStudent( new Student() );
            }
            studentDtoToStudent1( internshipApplicantDto.getStudent(), internshipApplicant.getStudent() );
        }
        if ( internshipApplicantDto.getMotivationLetter() != null ) {
            internshipApplicant.setMotivationLetter( internshipApplicantDto.getMotivationLetter() );
        }
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUserName( userDto.getUserName() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    protected InternshipOpportunity internshipOpportunityDtoToInternshipOpportunity(InternshipOpportunityDto internshipOpportunityDto) {
        if ( internshipOpportunityDto == null ) {
            return null;
        }

        InternshipOpportunity internshipOpportunity = new InternshipOpportunity();

        internshipOpportunity.setId( internshipOpportunityDto.getId() );
        internshipOpportunity.setLocation( internshipOpportunityDto.getLocation() );
        internshipOpportunity.setStartTime( internshipOpportunityDto.getStartTime() );
        internshipOpportunity.setDuration( internshipOpportunityDto.getDuration() );
        internshipOpportunity.setIsPayable( internshipOpportunityDto.getIsPayable() );
        internshipOpportunity.setNumberOfPositions( internshipOpportunityDto.getNumberOfPositions() );
        internshipOpportunity.setComment( internshipOpportunityDto.getComment() );
        internshipOpportunity.setUser( userDtoToUser( internshipOpportunityDto.getUser() ) );

        return internshipOpportunity;
    }

    protected Student studentDtoToStudent(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDto.getId() );
        student.setIsAvailable( studentDto.getIsAvailable() );

        return student;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUserName( user.getUserName() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }

    protected InternshipOpportunityDto internshipOpportunityToInternshipOpportunityDto(InternshipOpportunity internshipOpportunity) {
        if ( internshipOpportunity == null ) {
            return null;
        }

        InternshipOpportunityDto internshipOpportunityDto = new InternshipOpportunityDto();

        internshipOpportunityDto.setId( internshipOpportunity.getId() );
        internshipOpportunityDto.setLocation( internshipOpportunity.getLocation() );
        internshipOpportunityDto.setStartTime( internshipOpportunity.getStartTime() );
        internshipOpportunityDto.setDuration( internshipOpportunity.getDuration() );
        internshipOpportunityDto.setIsPayable( internshipOpportunity.getIsPayable() );
        internshipOpportunityDto.setNumberOfPositions( internshipOpportunity.getNumberOfPositions() );
        internshipOpportunityDto.setComment( internshipOpportunity.getComment() );
        internshipOpportunityDto.setUser( userToUserDto( internshipOpportunity.getUser() ) );

        return internshipOpportunityDto;
    }

    protected StudentDto studentToStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        Integer id = null;
        Boolean isAvailable = null;

        id = student.getId();
        isAvailable = student.getIsAvailable();

        Integer userId = null;
        String userUserName = null;
        String userPassword = null;
        Integer studentProfileId = null;
        String studentProfileAvailableFrom = null;
        String studentProfileLocation = null;
        LocalDate studentProfileDateOfBirth = null;
        String studentProfileCompetence = null;
        String studentProfileStrength = null;
        String studentProfileAboutMe = null;
        String studentProfileLinkedin = null;
        String studentProfileGithubLink = null;

        StudentDto studentDto = new StudentDto( id, userId, userUserName, userPassword, studentProfileId, studentProfileAvailableFrom, studentProfileLocation, studentProfileDateOfBirth, studentProfileCompetence, studentProfileStrength, studentProfileAboutMe, studentProfileLinkedin, studentProfileGithubLink, isAvailable );

        return studentDto;
    }

    protected void userDtoToUser1(UserDto userDto, User mappingTarget) {
        if ( userDto == null ) {
            return;
        }

        if ( userDto.getId() != null ) {
            mappingTarget.setId( userDto.getId() );
        }
        if ( userDto.getUserName() != null ) {
            mappingTarget.setUserName( userDto.getUserName() );
        }
        if ( userDto.getPassword() != null ) {
            mappingTarget.setPassword( userDto.getPassword() );
        }
    }

    protected void internshipOpportunityDtoToInternshipOpportunity1(InternshipOpportunityDto internshipOpportunityDto, InternshipOpportunity mappingTarget) {
        if ( internshipOpportunityDto == null ) {
            return;
        }

        if ( internshipOpportunityDto.getId() != null ) {
            mappingTarget.setId( internshipOpportunityDto.getId() );
        }
        if ( internshipOpportunityDto.getLocation() != null ) {
            mappingTarget.setLocation( internshipOpportunityDto.getLocation() );
        }
        if ( internshipOpportunityDto.getStartTime() != null ) {
            mappingTarget.setStartTime( internshipOpportunityDto.getStartTime() );
        }
        if ( internshipOpportunityDto.getDuration() != null ) {
            mappingTarget.setDuration( internshipOpportunityDto.getDuration() );
        }
        if ( internshipOpportunityDto.getIsPayable() != null ) {
            mappingTarget.setIsPayable( internshipOpportunityDto.getIsPayable() );
        }
        if ( internshipOpportunityDto.getNumberOfPositions() != null ) {
            mappingTarget.setNumberOfPositions( internshipOpportunityDto.getNumberOfPositions() );
        }
        if ( internshipOpportunityDto.getComment() != null ) {
            mappingTarget.setComment( internshipOpportunityDto.getComment() );
        }
        if ( internshipOpportunityDto.getUser() != null ) {
            if ( mappingTarget.getUser() == null ) {
                mappingTarget.setUser( new User() );
            }
            userDtoToUser1( internshipOpportunityDto.getUser(), mappingTarget.getUser() );
        }
    }

    protected void studentDtoToStudent1(StudentDto studentDto, Student mappingTarget) {
        if ( studentDto == null ) {
            return;
        }

        if ( studentDto.getId() != null ) {
            mappingTarget.setId( studentDto.getId() );
        }
        if ( studentDto.getIsAvailable() != null ) {
            mappingTarget.setIsAvailable( studentDto.getIsAvailable() );
        }
    }
}
