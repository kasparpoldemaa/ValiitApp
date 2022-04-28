package com.example.demo.event;

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

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik eventid")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/id")
    @Operation(summary = "Tagastab eventi sisestatud ID järgi")
    public EventDto getEventById(@RequestParam Integer id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/new")
    @Operation(summary = "Lisab uue eventi")
    public EventDto addNewEvent(@Valid @RequestBody EventDto eventDto) {
        return eventService.addNewEvent(eventDto);
    }

}
