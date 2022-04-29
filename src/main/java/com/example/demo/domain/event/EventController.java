package com.example.demo.domain.event;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventService;

    @PostMapping("/add")
    @Operation(summary = "Lisab uue ürituse")
    public EventDto addNewEvent(@RequestBody EventDto eventDto) {
        return eventService.addNewEvent(eventDto);
    }
    @PutMapping("/update")
    @Operation(summary = "Uuendab üritust id järgi")
    public void updateEvent(@RequestParam Integer eventId, @Valid @RequestBody EventDto eventDto) {
        eventService.updateEvent(eventId, eventDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik eventid")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Kustuta üritus id järgi")
    public void removeEventById(@RequestParam Integer eventId) {
        eventService.removeEventById(eventId);

    }



}
