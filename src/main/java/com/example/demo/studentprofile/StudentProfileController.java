package com.example.demo.studentprofile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student-profile")
public class StudentProfileController {

    @Resource
    private StudentProfileService studentProfileService;

}


