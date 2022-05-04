package com.example.demo.domain.contact;

import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.service.register.NewUserRequest;
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

//    public ContactDto addContact(Integer userId, ContactDto contactDto) {
//        Contact input = contactMapper.toEntity(contactDto);
//        Contact contact = createAndSaveContact(userId, input);
//        return contactMapper.toDto(contact);
//    }
//
//    private Contact createAndSaveContact(Integer userId, Contact input) {
//        Contact contact = new Contact();
//        contact.setUser(userService.findUserByUserId(userId));
//        contact.setFirstName(input.getFirstName());
//        contact.setLastName(input.getLastName());
//        contact.setCompanyName(input.getCompanyName());
//        contact.setAddress(input.getAddress());
//        contactRepository.save(contact);
//        return contact;
//    }


    public Integer addNewContact(Integer userId, NewUserRequest request) {
        User user = userService.findUserByUserId(userId);
        Contact contact = new Contact();
        contact.setAddress(request.getAddress());
        contact.setCompanyName(request.getCompanyName());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setUser(user);
        contactRepository.save(contact);
        return contact.getId();
    }

    public Integer getContactIdByUser(Integer id) {
        Contact contact = contactRepository.findByUser_Id(id);
        return contact.getId();
    }

    public ContactDto getContactById(Integer contactId) {
        return contactMapper.toDto(contactRepository.getById(contactId));
    }
}
