package com.example.demo.event;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T10:11:14+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public Event toEntity(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        Event event = new Event();

        event.setDate( eventDto.getDate() );
        event.setEventName( eventDto.getEventName() );
        event.setCompany( eventDto.getCompany() );
        event.setZoom( eventDto.getZoom() );
        event.setPresenterName( eventDto.getPresenterName() );

        return event;
    }

    @Override
    public EventDto toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setId( event.getId() );
        eventDto.setDate( event.getDate() );
        eventDto.setTime( event.getTime() );
        eventDto.setEventName( event.getEventName() );
        eventDto.setCompany( event.getCompany() );
        eventDto.setZoom( event.getZoom() );
        eventDto.setPresenterName( event.getPresenterName() );

        return eventDto;
    }

    @Override
    public List<EventDto> toDtos(List<Event> event) {
        if ( event == null ) {
            return null;
        }

        List<EventDto> list = new ArrayList<EventDto>( event.size() );
        for ( Event event1 : event ) {
            list.add( toDto( event1 ) );
        }

        return list;
    }

    @Override
    public void updateEventFromEventDto(EventDto eventDto, Event event) {
        if ( eventDto == null ) {
            return;
        }

        if ( eventDto.getId() != null ) {
            event.setId( eventDto.getId() );
        }
        if ( eventDto.getDate() != null ) {
            event.setDate( eventDto.getDate() );
        }
        if ( eventDto.getTime() != null ) {
            event.setTime( eventDto.getTime() );
        }
        if ( eventDto.getEventName() != null ) {
            event.setEventName( eventDto.getEventName() );
        }
        if ( eventDto.getCompany() != null ) {
            event.setCompany( eventDto.getCompany() );
        }
        if ( eventDto.getZoom() != null ) {
            event.setZoom( eventDto.getZoom() );
        }
        if ( eventDto.getPresenterName() != null ) {
            event.setPresenterName( eventDto.getPresenterName() );
        }
    }
}
