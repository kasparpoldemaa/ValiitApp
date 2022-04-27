package com.example.demo.contact;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;
}
