package com.example.demo.event;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "\"time\"", nullable = false)
    private LocalTime time;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "zoom")
    private String zoom;

    @Column(name = "presenter_name")
    private String presenterName;

}