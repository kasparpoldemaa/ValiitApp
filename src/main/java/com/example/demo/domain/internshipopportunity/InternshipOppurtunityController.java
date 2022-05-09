package com.example.demo.domain.internshipopportunity;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/internship-oppurtunity")
public class InternshipOppurtunityController {

    @Resource
    private InternshipOppurtunityService internshipOppurtunityService;




}
