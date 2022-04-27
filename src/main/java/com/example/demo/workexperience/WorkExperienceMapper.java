package com.example.demo.workexperience;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WorkExperienceMapper {
    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "studentUserId", target = "user.id")
    @Mapping(source = "studentUserUserName", target = "user.userName")
    @Mapping(source = "studentUserPassword", target = "user.password")
    @Mapping(source = "studentStudentProfileId", target = "studentProfile.id")
    @Mapping(source = "studentStudentProfileAvailableFrom", target = "studentProfile.availableFrom")
    @Mapping(source = "studentStudentProfileLocation", target = "studentProfile.location")
    @Mapping(source = "studentStudentProfileDateOfBirth", target = "studentProfile.dateOfBirth")
    @Mapping(source = "studentStudentProfileCompetence", target = "studentProfile.competence")
    @Mapping(source = "studentStudentProfileStrength", target = "studentProfile.strength")
    @Mapping(source = "studentStudentProfileAboutMe", target = "studentProfile.aboutMe")
    @Mapping(source = "studentStudentProfileLinkedin", target = "studentProfile.linkedin")
    @Mapping(source = "studentStudentProfileGithubLink", target = "studentProfile.githubLink")
    @Mapping(source = "studentIsAvailable", target = "student.isAvailable")
    WorkExperience toEntity(WorkExperienceDto workExperienceDto);

    @InheritInverseConfiguration(name = "workExperienceDtoToWorkExperience")
    WorkExperienceDto toDto(WorkExperience workExperience);

    @InheritConfiguration(name = "workExperienceDtoToWorkExperience")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateWorkExperienceFromWorkExperienceDto(WorkExperienceDto workExperienceDto, @MappingTarget WorkExperience workExperience);
}
