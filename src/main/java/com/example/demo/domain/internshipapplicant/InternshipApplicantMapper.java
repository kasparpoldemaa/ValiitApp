package com.example.demo.domain.internshipapplicant;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InternshipApplicantMapper {
    InternshipApplicant toEntity(InternshipApplicantDto internshipApplicantDto);

    InternshipApplicantDto toDto(InternshipApplicant internshipApplicant);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInternshipApplicantFromInternshipApplicantDto(InternshipApplicantDto internshipApplicantDto, @MappingTarget InternshipApplicant internshipApplicant);
}
