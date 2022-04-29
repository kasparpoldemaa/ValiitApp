package com.example.demo.domain.event;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventDto eventDto);

    EventDto toDto(Event event);

    List<EventDto>toDtos(List<Event> event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(EventDto eventDto, @MappingTarget Event event);
}
