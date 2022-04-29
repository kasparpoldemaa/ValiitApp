package com.example.demo.event;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EventDto implements Serializable {
    private final Integer id;
    private final LocalDate date;
    private final String time;
    private final String eventName;
    private final String company;
    private final String zoom;
    private final String presenterName;
}
