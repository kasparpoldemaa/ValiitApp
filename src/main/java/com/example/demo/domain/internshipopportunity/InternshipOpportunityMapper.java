package com.example.demo.domain.internshipopportunity;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InternshipOpportunityMapper {


//    @Mapping(source = "user.id", target = "userId")
    List<InternshipOpportunityDto> toDtos(List<InternshipOpportunity> internshipOpportunity);


}
