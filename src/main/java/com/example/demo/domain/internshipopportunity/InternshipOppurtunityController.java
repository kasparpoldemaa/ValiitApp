package com.example.demo.domain.internshipopportunity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/internship-oppurtunity")
public class InternshipOppurtunityController {

    @Resource
    private InternshipOppurtunityService internshipOppurtunityService;


}
