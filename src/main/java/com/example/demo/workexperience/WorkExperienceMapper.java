package com.example.demo.workexperience;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WorkExperienceMapper {

    WorkExperience toEntity(WorkExperienceDto dto);

    WorkExperienceDto toDto(WorkExperience entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(WorkExperienceDto dto, @MappingTarget WorkExperience entity);
}
