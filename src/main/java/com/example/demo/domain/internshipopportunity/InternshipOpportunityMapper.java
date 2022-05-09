package com.example.demo.domain.internshipopportunity;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InternshipOpportunityMapper {

    InternshipOpportunityDto toDto(InternshipOpportunity internshipOpportunity);

    //    @Mapping(source = "user.id", target = "userId")
//    @Mapping(target = "opportunityId", ignore = true)
    List<InternshipOpportunityDto> toDtos(List<InternshipOpportunity> internshipOpportunity);


}
