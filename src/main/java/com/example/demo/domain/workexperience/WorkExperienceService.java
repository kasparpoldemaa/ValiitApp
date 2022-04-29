package com.example.demo.domain.workexperience;

import com.example.demo.domain.student.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkExperienceService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private WorkExperienceRepository workExperienceRepository;

    @Resource
    private WorkExperienceMapper workExperienceMapper;

//TODO: - studentRepository ei tohiks siin klassis olla.
    public WorkExperienceDto addNewWorkExperience(Integer studentId, WorkExperienceDto workExperienceDto) {
        WorkExperience workExperience = workExperienceMapper.toEntity(workExperienceDto);
        workExperience.setStudent(studentRepository.getById(studentId));
        workExperienceRepository.save(workExperience);
        return workExperienceMapper.toDto(workExperience);
    }


    public WorkExperienceDto getWorkExperienceById(Integer studentId) {
        WorkExperience workExperience = workExperienceRepository.getById(studentId);
        return workExperienceMapper.toDto(workExperience);

    }

    public void updateWorkExperienceById(Integer workExperienceId, WorkExperienceDto workExperienceDto) {
        WorkExperience workExperience = workExperienceRepository.getById(workExperienceId);
        workExperienceMapper.updateEntity(workExperienceDto,workExperience);
//        workExperience.setStartDate(workExperienceDto.getStartDate());
//        workExperience.setEndDate(workExperienceDto.getEndDate());
//        workExperience.setCompanyName(workExperienceDto.getCompanyName());
//        workExperience.setPosition(workExperienceDto.getPosition());
//        workExperience.setJobDescription(workExperienceDto.getJobDescription());
        workExperienceRepository.save(workExperience);

    }

    public void removeWorkExperienceById(Integer workExperienceId) {
        workExperienceRepository.deleteById(workExperienceId);

    }
}
