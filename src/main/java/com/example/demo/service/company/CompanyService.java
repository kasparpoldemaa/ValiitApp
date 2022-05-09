package com.example.demo.service.company;

import com.example.demo.domain.internshipapplicant.InternshipApplicantService;
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

    @Resource
    private InternshipApplicantService internshipApplicantService;

    public CompanyResponse addNewInternship(Boolean isPayable, Integer userId, InternshipOpportunityDto dto) {
        return internshipOppurtunityService.addNewInternship(isPayable, userId, dto);
    }

        public List<InternshipOpportunityDto> getAllOffersByUserId(Integer userId) {
        List<InternshipOpportunity> internshipOpportunities = internshipOpportunityRepository.findByUserId(userId);

            List<InternshipOpportunityDto> opportunityDtos = internshipOpportunityMapper.toDtos(internshipOpportunities);
            for (InternshipOpportunityDto opportunityDto : opportunityDtos) {
                Integer count = internshipApplicantService.getApplicantCount(opportunityDto.getId());
                List<Integer> appliedStudentIds = internshipApplicantService.getAppliedStudentIds(opportunityDto.getId());
                opportunityDto.setInterestedCount(count);
                opportunityDto.setStudentId(appliedStudentIds);
            }
            return opportunityDtos;
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
