package com.example.demo.domain.educationexperience;

import com.example.demo.domain.workexperience.WorkExperience;
import com.example.demo.domain.workexperience.WorkExperienceDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EducationExperienceMapper {

    EducationExperience toEntity(EducationExperienceDto educationExperienceDto);

    EducationExperienceDto toDto(EducationExperience educationExperience);
    List<EducationExperienceDto> toDtos(List<EducationExperience> educationExperiences);

    @Mapping(target= "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(EducationExperienceDto dto, @MappingTarget EducationExperience entity);
}
