package com.example.demo.domain.picture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Resource
    private PictureService pictureService;

}
