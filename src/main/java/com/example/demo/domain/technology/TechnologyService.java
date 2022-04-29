package com.example.demo.domain.technology;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TechnologyService {

    @Resource
    private TechnologyMapper technologyMapper;

    @Resource
    private TechnologyRepository technologyRepository;

}
