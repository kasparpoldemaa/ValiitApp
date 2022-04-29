package com.example.demo.event;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventService;

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik eventid")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

}
