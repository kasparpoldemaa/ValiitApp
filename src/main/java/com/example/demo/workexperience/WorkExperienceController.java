package com.example.demo.workexperience;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/work-experience")
public class WorkExperienceController {

    @Resource
    private WorkExperienceService workExperienceService;
}
