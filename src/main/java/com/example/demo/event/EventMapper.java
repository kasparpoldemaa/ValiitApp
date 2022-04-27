package com.example.demo.event;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "time", ignore = true)
//    @Mapping(target = "date", ignore = true)
//    @Mapping(target = "id", ignore = true)
    Event toEntity(EventDto eventDto);

    EventDto toDto(Event event);

    List<EventDto> toDtos(List<Event> event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEventFromEventDto(EventDto eventDto, @MappingTarget Event event);
}
