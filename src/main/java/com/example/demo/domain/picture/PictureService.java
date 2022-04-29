package com.example.demo.domain.picture;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PictureService {


    @Resource
    private PictureRepository pictureRepository;
}
