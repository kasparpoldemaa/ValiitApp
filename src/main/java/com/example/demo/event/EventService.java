package com.example.demo.event;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventService {

    @Resource
    private EventMapper eventMapper;

    @Resource
    private EventRepository eventRepository;


    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDtos(events);
    }

    public EventDto getEventById(Integer id) {
        Event event = eventRepository.getById(id);
        return eventMapper.toDto(event);
    }

    public EventDto addNewEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        eventRepository.save(event);
        return eventMapper.toDto(event);
    }
}
