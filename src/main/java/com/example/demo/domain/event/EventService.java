package com.example.demo.domain.event;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private EventMapper eventMapper;

    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDtos(events);
    }
}
