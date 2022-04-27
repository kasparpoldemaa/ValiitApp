package com.example.demo.workoption;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/work-option")
public class WorkOptionController {

    @Resource
    private WorkOptionService workOptionService;

}
