package com.example.demo.service.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureRequest implements Serializable {
    private final Integer studentId;
    private final byte[] base64;
}
