package com.example.demo.student;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userUserName", target = "user.userName")
    @Mapping(source = "userPassword", target = "user.password")
    @Mapping(source = "studentProfileId", target = "studentProfile.id")
    @Mapping(source = "studentProfileAvailableFrom", target = "studentProfile.availableFrom")
    @Mapping(source = "studentProfileLocation", target = "studentProfile.location")
    @Mapping(source = "studentProfileDateOfBirth", target = "studentProfile.dateOfBirth")
    @Mapping(source = "studentProfileCompetence", target = "studentProfile.competence")
    @Mapping(source = "studentProfileStrength", target = "studentProfile.strength")
    @Mapping(source = "studentProfileAboutMe", target = "studentProfile.aboutMe")
    @Mapping(source = "studentProfileLinkedin", target = "studentProfile.linkedin")
    @Mapping(source = "studentProfileGithubLink", target = "studentProfile.githubLink")
    Student toEntity(StudentDto studentDto);

    @InheritInverseConfiguration(name = "toEntity")
    StudentDto toDto(Student student);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromStudentDto(StudentDto studentDto, @MappingTarget Student student);
}
