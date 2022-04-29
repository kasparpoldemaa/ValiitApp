package com.example.demo.domain.student;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentRepository studentRepository;
}
