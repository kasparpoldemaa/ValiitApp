package com.example.demo.domain.student;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer studentProfileId;
    private Boolean isAvailable;
    private Integer pictureId;
}
