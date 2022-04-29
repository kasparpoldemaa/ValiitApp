package com.example.demo.domain.educationexperience;

import com.example.demo.domain.event.Event;
import com.example.demo.domain.event.EventDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EducationExperienceMapper {
    //@Mapping(source = "studentId", target = "student.id")
    EducationExperience toEntity(EducationExperienceDto educationExperienceDto);

    //@Mapping(source = "student.id", target = "studentId")
    EducationExperienceDto toDto(EducationExperience educationExperience);

    List<EducationExperienceDto> toDtos(List<EducationExperience> educationExperiences);

    //@Mapping(source = "studentId", target = "student.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(EducationExperienceDto educationExperienceDto, @MappingTarget EducationExperience educationExperience);
}
