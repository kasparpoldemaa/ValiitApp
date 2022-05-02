package com.example.demo.domain.contact;

import com.example.demo.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private UserService userService;

    @Resource
    private ContactRepository contactRepository;

    public ContactDto addContact(Integer userId, ContactDto contactDto) {
        Contact input = contactMapper.toEntity(contactDto);
        Contact contact = createAndSaveContact(userId, input);
        return contactMapper.toDto(contact);
    }

    private Contact createAndSaveContact(Integer userId, Contact input) {
        Contact contact = new Contact();
        contact.setUser(userService.findUserByUserId(userId));
        contact.setFirstName(input.getFirstName());
        contact.setLastName(input.getLastName());
        contact.setCompanyName(input.getCompanyName());
        contact.setAddress(input.getAddress());
        contactRepository.save(contact);
        return contact;
    }


}
