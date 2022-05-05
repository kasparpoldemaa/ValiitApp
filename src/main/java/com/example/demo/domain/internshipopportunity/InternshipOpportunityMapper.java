package com.example.demo.domain.internshipopportunity;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InternshipOpportunityMapper {
//    @Mapping(source = "userId", target = "user.id")
//    InternshipOpportunity internshipOpportunityDtoToInternshipOpportunity(InternshipOpportunityDto internshipOpportunityDto);

//    @Mapping(source = "user.id", target = "userId")
//    InternshipOpportunityDto internshipOpportunityToInternshipOpportunityDto(InternshipOpportunity internshipOpportunity);

//    @Mapping(source = "userId", target = "user.id")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateInternshipOpportunityFromInternshipOpportunityDto(InternshipOpportunityDto internshipOpportunityDto, @MappingTarget InternshipOpportunity internshipOpportunity);
}
