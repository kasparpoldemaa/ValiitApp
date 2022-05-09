package com.example.demo.domain.internshipapplicant;

import com.example.demo.service.applicant.ApplicantResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InternshipApplicantMapper {
    InternshipApplicant toEntity(InternshipApplicantDto internshipApplicantDto);

    ApplicantResponse toDto(InternshipApplicant internshipApplicant);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInternshipApplicantFromInternshipApplicantDto(InternshipApplicantDto internshipApplicantDto, @MappingTarget InternshipApplicant internshipApplicant);
}
