package com.example.demo.domain.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer studentProfileId;
    private Boolean isAvailable;
}
