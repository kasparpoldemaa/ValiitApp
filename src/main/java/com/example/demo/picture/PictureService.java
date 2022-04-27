package com.example.demo.picture;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PictureService {

    @Resource
    private PictureMapper pictureMapper;

    @Resource
    private PictureRepository pictureRepository;
}
