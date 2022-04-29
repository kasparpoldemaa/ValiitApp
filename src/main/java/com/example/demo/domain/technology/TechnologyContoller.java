package com.example.demo.domain.technology;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/technology")
public class TechnologyContoller {

    @Resource
    private TechnologyService technologyService;
}
