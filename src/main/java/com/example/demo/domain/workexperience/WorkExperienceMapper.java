package com.example.demo.domain.workexperience;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WorkExperienceMapper {



    WorkExperience toEntity(WorkExperienceDto dto);

    WorkExperienceDto toDto(WorkExperience entity);

    List<WorkExperienceDto> toDtos(List<WorkExperience> entity);

    @Mapping(target= "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(WorkExperienceDto dto, @MappingTarget WorkExperience entity);
}
