package com.example.demo.domain.educationexperience;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EducationExperienceMapper {
    @Mapping(source = "studentId", target = "student.id")
    EducationExperience toEntity(EducationExperienceDto educationExperienceDto);

    @Mapping(source = "student.id", target = "studentId")
    EducationExperienceDto toDto(EducationExperience educationExperience);

    @Mapping(source = "studentId", target = "student.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(EducationExperienceDto educationExperienceDto, @MappingTarget EducationExperience educationExperience);
}
