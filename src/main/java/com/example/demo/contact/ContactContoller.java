package com.example.demo.contact;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/contact")
public class ContactContoller {

    @Resource
    private ContactService contactService;

}
