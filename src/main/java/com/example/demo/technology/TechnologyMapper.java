package com.example.demo.technology;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TechnologyMapper {
    Technology toEntity(TechnologyDto technologyDto);

    TechnologyDto toDto(Technology technology);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTechnologyFromTechnologyDto(TechnologyDto technologyDto, @MappingTarget Technology technology);
}
