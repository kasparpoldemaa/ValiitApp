package com.example.demo.workexperience;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WorkExperienceMapper {
    WorkExperience toEntity(WorkExperienceDto workExperienceDto);

    WorkExperienceDto toDto(WorkExperience workExperience);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(WorkExperienceDto workExperienceDto, @MappingTarget WorkExperience workExperience);
}
