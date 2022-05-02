package com.example.demo.service.picture;

import com.example.demo.domain.picture.PictureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/picture")
public class PictureContoller {

        @Resource
        private PictureService pictureService;

}
