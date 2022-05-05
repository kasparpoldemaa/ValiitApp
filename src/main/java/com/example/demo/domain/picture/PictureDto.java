package com.example.demo.domain.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureDto implements Serializable {
    private Integer id;
    private byte[] base64;
}
