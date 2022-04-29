package com.example.demo.domain.workoption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkOptionDto implements Serializable {
    private Integer id;
    private String option;
    private String description;
}
