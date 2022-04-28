package com.example.demo.technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDto implements Serializable {
    private Integer id;
    private String name;
}
