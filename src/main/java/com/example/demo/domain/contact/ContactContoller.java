package com.example.demo.domain.contact;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/contact")
public class ContactContoller {

    @Resource
    private ContactService contactService;

    @GetMapping("/id")
    @Operation(summary = "Leiab kontaktinfo Id järgi")
    public ContactDto getContactById(Integer contactId) {
        return contactService.getContactById(contactId);
    }

}
