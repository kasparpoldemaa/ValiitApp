package com.example.demo.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto implements Serializable {
    private Integer id;
    private LocalDate date;
    @JsonFormat(pattern = "hh:mm:ss.zzz", shape = JsonFormat.Shape.STRING)
    private LocalTime time;
    private String eventName;
    private String company;
    private String zoom;
    private String presenterName;
}
