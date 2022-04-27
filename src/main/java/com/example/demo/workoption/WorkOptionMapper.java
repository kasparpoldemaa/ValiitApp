package com.example.demo.workoption;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WorkOptionMapper {
    WorkOption toEntity(WorkOptionDto workOptionDto);

    WorkOptionDto toDto(WorkOption workOption);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateWorkOptionFromWorkOptionDto(WorkOptionDto workOptionDto, @MappingTarget WorkOption workOption);
}
