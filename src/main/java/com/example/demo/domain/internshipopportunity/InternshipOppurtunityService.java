package com.example.demo.domain.internshipopportunity;

import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.service.company.CompanyResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InternshipOppurtunityService {

    @Resource
    private UserService userService;

    @Resource
    private InternshipOpportunityRepository internshipOpportunityRepository;

    public CompanyResponse addNewInternship(Boolean isPayable, Integer userId, InternshipOpportunityDto dto) {

        User user = userService.findUserByUserId(userId);

        InternshipOpportunity internshipOpportunity = new InternshipOpportunity();
        internshipOpportunity.setUser(user);
        internshipOpportunity.setComment(dto.getComment());
        internshipOpportunity.setDuration(dto.getDuration());
        internshipOpportunity.setLocation(dto.getLocation());
        internshipOpportunity.setIsPayable(isPayable);
        internshipOpportunity.setStartTime(dto.getStartTime());
        internshipOpportunity.setNumberOfPositions(dto.getNumberOfPositions());
        internshipOpportunity.setTechnology(dto.getTechnology());
        internshipOpportunity.setWorkType(dto.getWorkType());
        internshipOpportunityRepository.save(internshipOpportunity);

        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setInternshipOppurtunityId(internshipOpportunity.getId());
        companyResponse.setUserId(user.getId());

        return companyResponse;
    }

    public InternshipOpportunity getOfferById(Integer offerId) {
        return internshipOpportunityRepository.getById(offerId);
    }
}
