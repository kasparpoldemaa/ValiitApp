package com.example.demo.domain.requiredtechnology;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/required-technology")
public class RequiredTechnologyController {

    @Resource
    private RequiredTechnologyService requiredTechnologyService;
}
