package com.example.demo.service.image;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImageRequest implements Serializable {
    private Integer studentId;
    private String base64;
}
