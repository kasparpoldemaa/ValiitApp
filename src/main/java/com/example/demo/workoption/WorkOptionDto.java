package com.example.demo.workoption;

import lombok.Data;

import java.io.Serializable;

@Data
public class WorkOptionDto implements Serializable {
    private final Integer id;
    private final String option;
    private final String description;
}
