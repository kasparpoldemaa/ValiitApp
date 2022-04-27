package com.example.demo.technology;

import lombok.Data;

import java.io.Serializable;

@Data
public class TechnologyDto implements Serializable {
    private final Integer id;
    private final String name;
}
