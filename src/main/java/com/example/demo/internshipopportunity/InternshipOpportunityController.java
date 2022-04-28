package com.example.demo.internshipopportunity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/internship-opportunity")
public class InternshipOpportunityController {

    @Resource
    private InternshipOpportunityService internshipOpportunityService;
}
