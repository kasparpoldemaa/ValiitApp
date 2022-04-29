package com.example.demo.domain.workoption;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkOptionService {

    @Resource
    private WorkOptionMapper workOptionMapper;

    @Resource
    private WorkOptionRepository workOptionRepository;

}
