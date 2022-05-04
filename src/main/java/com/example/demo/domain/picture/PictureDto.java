package com.example.demo.domain.picture;

import com.example.demo.domain.student.StudentDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class PictureDto implements Serializable {
    private  Integer id;
    private  StudentDto student;
    private  byte[] base64;
}
