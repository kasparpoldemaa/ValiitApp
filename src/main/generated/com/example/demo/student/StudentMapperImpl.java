package com.example.demo.student;

import com.example.demo.studentprofile.StudentProfile;
import com.example.demo.user.User;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T14:47:55+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setUser( studentDtoToUser( studentDto ) );
        student.setStudentProfile( studentDtoToStudentProfile( studentDto ) );
        student.setId( studentDto.getId() );
        student.setIsAvailable( studentDto.getIsAvailable() );

        return student;
    }

    @Override
    public StudentDto toDto(Student student) {
        if ( student == null ) {
            return null;
        }

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
        Integer id = null;
        Boolean isAvailable = null;

        userId = studentUserId( student );
        userUserName = studentUserUserName( student );
        userPassword = studentUserPassword( student );
        studentProfileId = studentStudentProfileId( student );
        studentProfileAvailableFrom = studentStudentProfileAvailableFrom( student );
        studentProfileLocation = studentStudentProfileLocation( student );
        studentProfileDateOfBirth = studentStudentProfileDateOfBirth( student );
        studentProfileCompetence = studentStudentProfileCompetence( student );
        studentProfileStrength = studentStudentProfileStrength( student );
        studentProfileAboutMe = studentStudentProfileAboutMe( student );
        studentProfileLinkedin = studentStudentProfileLinkedin( student );
        studentProfileGithubLink = studentStudentProfileGithubLink( student );
        id = student.getId();
        isAvailable = student.getIsAvailable();

        StudentDto studentDto = new StudentDto( id, userId, userUserName, userPassword, studentProfileId, studentProfileAvailableFrom, studentProfileLocation, studentProfileDateOfBirth, studentProfileCompetence, studentProfileStrength, studentProfileAboutMe, studentProfileLinkedin, studentProfileGithubLink, isAvailable );

        return studentDto;
    }

    @Override
    public void updateStudentFromStudentDto(StudentDto studentDto, Student student) {
        if ( studentDto == null ) {
            return;
        }

        if ( student.getUser() == null ) {
            student.setUser( new User() );
        }
        studentDtoToUser1( studentDto, student.getUser() );
        if ( student.getStudentProfile() == null ) {
            student.setStudentProfile( new StudentProfile() );
        }
        studentDtoToStudentProfile1( studentDto, student.getStudentProfile() );
        if ( studentDto.getId() != null ) {
            student.setId( studentDto.getId() );
        }
        if ( studentDto.getIsAvailable() != null ) {
            student.setIsAvailable( studentDto.getIsAvailable() );
        }
    }

    protected User studentDtoToUser(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( studentDto.getUserId() );
        user.setUserName( studentDto.getUserUserName() );
        user.setPassword( studentDto.getUserPassword() );

        return user;
    }

    protected StudentProfile studentDtoToStudentProfile(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        StudentProfile studentProfile = new StudentProfile();

        studentProfile.setId( studentDto.getStudentProfileId() );
        studentProfile.setAvailableFrom( studentDto.getStudentProfileAvailableFrom() );
        studentProfile.setLocation( studentDto.getStudentProfileLocation() );
        studentProfile.setDateOfBirth( studentDto.getStudentProfileDateOfBirth() );
        studentProfile.setCompetence( studentDto.getStudentProfileCompetence() );
        studentProfile.setStrength( studentDto.getStudentProfileStrength() );
        studentProfile.setAboutMe( studentDto.getStudentProfileAboutMe() );
        studentProfile.setLinkedin( studentDto.getStudentProfileLinkedin() );
        studentProfile.setGithubLink( studentDto.getStudentProfileGithubLink() );

        return studentProfile;
    }

    private Integer studentUserId(Student student) {
        if ( student == null ) {
            return null;
        }
        User user = student.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String studentUserUserName(Student student) {
        if ( student == null ) {
            return null;
        }
        User user = student.getUser();
        if ( user == null ) {
            return null;
        }
        String userName = user.getUserName();
        if ( userName == null ) {
            return null;
        }
        return userName;
    }

    private String studentUserPassword(Student student) {
        if ( student == null ) {
            return null;
        }
        User user = student.getUser();
        if ( user == null ) {
            return null;
        }
        String password = user.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }

    private Integer studentStudentProfileId(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        Integer id = studentProfile.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String studentStudentProfileAvailableFrom(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        String availableFrom = studentProfile.getAvailableFrom();
        if ( availableFrom == null ) {
            return null;
        }
        return availableFrom;
    }

    private String studentStudentProfileLocation(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        String location = studentProfile.getLocation();
        if ( location == null ) {
            return null;
        }
        return location;
    }

    private LocalDate studentStudentProfileDateOfBirth(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        LocalDate dateOfBirth = studentProfile.getDateOfBirth();
        if ( dateOfBirth == null ) {
            return null;
        }
        return dateOfBirth;
    }

    private String studentStudentProfileCompetence(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        String competence = studentProfile.getCompetence();
        if ( competence == null ) {
            return null;
        }
        return competence;
    }

    private String studentStudentProfileStrength(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        String strength = studentProfile.getStrength();
        if ( strength == null ) {
            return null;
        }
        return strength;
    }

    private String studentStudentProfileAboutMe(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        String aboutMe = studentProfile.getAboutMe();
        if ( aboutMe == null ) {
            return null;
        }
        return aboutMe;
    }

    private String studentStudentProfileLinkedin(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        String linkedin = studentProfile.getLinkedin();
        if ( linkedin == null ) {
            return null;
        }
        return linkedin;
    }

    private String studentStudentProfileGithubLink(Student student) {
        if ( student == null ) {
            return null;
        }
        StudentProfile studentProfile = student.getStudentProfile();
        if ( studentProfile == null ) {
            return null;
        }
        String githubLink = studentProfile.getGithubLink();
        if ( githubLink == null ) {
            return null;
        }
        return githubLink;
    }

    protected void studentDtoToUser1(StudentDto studentDto, User mappingTarget) {
        if ( studentDto == null ) {
            return;
        }

        if ( studentDto.getUserId() != null ) {
            mappingTarget.setId( studentDto.getUserId() );
        }
        if ( studentDto.getUserUserName() != null ) {
            mappingTarget.setUserName( studentDto.getUserUserName() );
        }
        if ( studentDto.getUserPassword() != null ) {
            mappingTarget.setPassword( studentDto.getUserPassword() );
        }
    }

    protected void studentDtoToStudentProfile1(StudentDto studentDto, StudentProfile mappingTarget) {
        if ( studentDto == null ) {
            return;
        }

        if ( studentDto.getStudentProfileId() != null ) {
            mappingTarget.setId( studentDto.getStudentProfileId() );
        }
        if ( studentDto.getStudentProfileAvailableFrom() != null ) {
            mappingTarget.setAvailableFrom( studentDto.getStudentProfileAvailableFrom() );
        }
        if ( studentDto.getStudentProfileLocation() != null ) {
            mappingTarget.setLocation( studentDto.getStudentProfileLocation() );
        }
        if ( studentDto.getStudentProfileDateOfBirth() != null ) {
            mappingTarget.setDateOfBirth( studentDto.getStudentProfileDateOfBirth() );
        }
        if ( studentDto.getStudentProfileCompetence() != null ) {
            mappingTarget.setCompetence( studentDto.getStudentProfileCompetence() );
        }
        if ( studentDto.getStudentProfileStrength() != null ) {
            mappingTarget.setStrength( studentDto.getStudentProfileStrength() );
        }
        if ( studentDto.getStudentProfileAboutMe() != null ) {
            mappingTarget.setAboutMe( studentDto.getStudentProfileAboutMe() );
        }
        if ( studentDto.getStudentProfileLinkedin() != null ) {
            mappingTarget.setLinkedin( studentDto.getStudentProfileLinkedin() );
        }
        if ( studentDto.getStudentProfileGithubLink() != null ) {
            mappingTarget.setGithubLink( studentDto.getStudentProfileGithubLink() );
        }
    }
}
