package com.example.demo.domain.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureDto implements Serializable {
    private final Integer id;
    //private final StudentDto student;
    private final byte[] base64;
}
