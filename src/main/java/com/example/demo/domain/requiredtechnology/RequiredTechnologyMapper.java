package com.example.demo.domain.requiredtechnology;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RequiredTechnologyMapper {
    RequiredTechnology toEntity(RequiredTechnologyDto requiredTechnologyDto);

    RequiredTechnologyDto toDto(RequiredTechnology requiredTechnology);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRequiredTechnologyFromRequiredTechnologyDto(RequiredTechnologyDto requiredTechnologyDto, @MappingTarget RequiredTechnology requiredTechnology);
}
