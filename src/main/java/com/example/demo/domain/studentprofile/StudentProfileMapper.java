package com.example.demo.domain.studentprofile;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentProfileMapper {
    StudentProfile toEntity(StudentProfileDto studentProfileDto);

    StudentProfileDto toDto(StudentProfile studentProfile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentProfileFromStudentProfileDto(StudentProfileDto studentProfileDto, @MappingTarget StudentProfile studentProfile);
}
