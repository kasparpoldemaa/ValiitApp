package com.example.demo.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto implements Serializable {
//    private final Integer id;
    private LocalDate date;
    private String time;
    private String eventName;
    private String company;
    private String zoom;
    private String presenterName;
}
