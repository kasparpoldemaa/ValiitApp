package com.example.demo.domain.contact;

import com.example.demo.domain.internshipopportunity.InternshipOppurtunityService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.service.profile.ApplicantResponse;
import com.example.demo.service.register.NewUserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private UserService userService;

    @Resource
    private ContactRepository contactRepository;

    @Resource
    private InternshipOppurtunityService internshipOppurtunityService;

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

    public List<ContactDto> getAllCompanyContacts() {
        List<ContactDto> contactDtos = contactMapper.toDtos(contactRepository.findAll());
        List<ContactDto> companyNames = new ArrayList<>();
        for (ContactDto contactDto : contactDtos) {
            if (contactDto.getCompanyName() != null) {
                contactDto.setApplicationCount(internshipOppurtunityService.countApplicationsByUserId(contactDto.getUserId()));
                companyNames.add(contactDto);
            }
        }
        return companyNames;
    }

    public String getCompanyNameByUserId(Integer userId) {
        return contactRepository.findByUser_Id(userId).getCompanyName();
    }

    public Contact getContact(Integer userId) {
        return contactRepository.getContact(userId);
    }

    public ApplicantResponse getStudentNameByUserId(Integer userId) {
        Contact contact = contactRepository.findByUser_Id(userId);
        ApplicantResponse applicantResponse = new ApplicantResponse();
        applicantResponse.setFirstName(contact.getFirstName());
        applicantResponse.setLastName(contact.getLastName());
        return applicantResponse;
    }
}

