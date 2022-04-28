package com.example.demo.requiredtechnology;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RequiredTechnologyService {

    @Resource
    private RequiredTechnologyMapper requiredTechnologyMapper;

    @Resource
    private RequiredTechnologyRepository requiredTechnologyRepository;
}
