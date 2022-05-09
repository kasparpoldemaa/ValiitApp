package com.example.demo.service.company;

import com.example.demo.domain.internshipopportunity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyService {

    @Resource
    private InternshipOpportunityRepository internshipOpportunityRepository;

    @Resource
    private InternshipOpportunityMapper internshipOpportunityMapper;

    @Resource
    private InternshipOppurtunityService internshipOppurtunityService;

    public CompanyResponse addNewInternship(Boolean isPayable, Integer userId, InternshipOpportunityDto dto) {
        CompanyResponse companyResponse = internshipOppurtunityService.addNewInternship(isPayable, userId, dto);
        return companyResponse;
    }

        public List<InternshipOpportunityDto> getAllOffersByUserId(Integer userId) {
        List<InternshipOpportunity> internshipOpportunities = internshipOpportunityRepository.findByUserId(userId);
        return internshipOpportunityMapper.toDtos(internshipOpportunities);
    }

    public void removeById(Integer id) {
        internshipOpportunityRepository.deleteById(id);
    }

    public List<InternshipOpportunityDto> getAllOffers() {



        return internshipOpportunityMapper.toDtos(internshipOpportunityRepository.findAll());
    }

    public InternshipOpportunityDto getOfferById(Integer offerId) {
        return internshipOpportunityMapper.toDto(internshipOpportunityRepository.getById(offerId));
    }
}
