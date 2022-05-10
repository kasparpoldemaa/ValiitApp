package com.example.demo.domain.internshipapplicant;

import com.example.demo.service.applicant.ApplicantResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InternshipApplicantMapper {
    InternshipApplicant toEntity(InternshipApplicantDto internshipApplicantDto);

    ApplicantResponse toDto(InternshipApplicant internshipApplicant);

    List<ApplicantResponse> toDtos(List<InternshipApplicant> internshipApplicants);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInternshipApplicantFromInternshipApplicantDto(InternshipApplicantDto internshipApplicantDto, @MappingTarget InternshipApplicant internshipApplicant);
}
