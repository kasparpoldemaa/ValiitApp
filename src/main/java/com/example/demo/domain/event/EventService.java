package com.example.demo.domain.event;

import com.example.demo.domain.workexperience.WorkExperience;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private EventMapper eventMapper;


    public EventDto addNewEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        eventRepository.save(event);
        return eventMapper.toDto(event);
    }

    public void updateEvent(Integer eventId, EventDto eventDto) {
        Event event = eventRepository.getById(eventId);
        eventMapper.updateEntity(eventDto, event);
        eventRepository.save(event);
    }

    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findByOrderByDateAsc();
        return eventMapper.toDtos(events);
    }

    public void removeEventById(Integer id) {
        eventRepository.deleteById(id);

    }

}
