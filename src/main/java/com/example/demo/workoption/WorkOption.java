package com.example.demo.workoption;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "work_options")
public class WorkOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "option", nullable = false)
    private String option;

    @Column(name = "description")
    private String description;

}