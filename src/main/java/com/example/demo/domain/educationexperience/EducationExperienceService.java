package com.example.demo.domain.educationexperience;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EducationExperienceService {

    @Resource
    private EducationExperienceMapper educationExperienceMapper;

    @Resource
    private EducationExperienceRepository educationExperienceRepository;


    public EducationExperienceDto getEducationExperienceById(Integer studentId) {
        EducationExperience educationExperience = educationExperienceRepository.getById(studentId);
        return educationExperienceMapper.toDto(educationExperience);
    }

    public void updateEducationExperienceById(Integer educationExperienceId, EducationExperienceDto educationExperienceDto) {
        EducationExperience educationExperience = educationExperienceRepository.getById(educationExperienceId);

        educationExperience.setStartDate(educationExperience.getStartDate());
        educationExperience.setEndDate(educationExperience.getEndDate());
        educationExperience.setSchool(educationExperience.getSchool());
        educationExperience.setDegree(educationExperience.getDegree());
        educationExperienceRepository.save(educationExperience);



    }

    public EducationExperience addNewEducationExperience(EducationExperienceDto educationExperienceDto) {
        return null;
    }
}
