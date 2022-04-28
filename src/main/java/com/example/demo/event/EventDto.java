package com.example.demo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto implements Serializable {
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private String eventName;
    private String company;
    private String zoom;
    private String presenterName;
}
