package com.example.demo.internshipopportunity;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InternshipOpportunityMapper {
    @Mapping(source = "workOptionsId", target = "workOptions.id")
    @Mapping(source = "workOptionsOption", target = "workOptions.option")
    @Mapping(source = "workOptionsDescription", target = "workOptions.description")
    InternshipOpportunity toEntity(InternshipOpportunityDto internshipOpportunityDto);

    @InheritInverseConfiguration(name = "toEntity")
    InternshipOpportunityDto toDto(InternshipOpportunity internshipOpportunity);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInternshipOpportunityFromInternshipOpportunityDto(InternshipOpportunityDto internshipOpportunityDto, @MappingTarget InternshipOpportunity internshipOpportunity);
}
