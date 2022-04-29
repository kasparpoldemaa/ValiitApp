package com.example.demo.domain.educationexperience;

import com.example.demo.domain.student.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EducationExperienceService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private EducationExperienceRepository educationExperienceRepository;

    @Resource
    private EducationExperienceMapper educationExperienceMapper;


    public EducationExperienceDto addNewEducationExperience(Integer studentId, EducationExperienceDto educationExperienceDto) {
        EducationExperience educationExperience = educationExperienceMapper.toEntity(educationExperienceDto);
        educationExperience.setStudent(studentRepository.getById(studentId));
        educationExperienceRepository.save(educationExperience);
        return educationExperienceMapper.toDto(educationExperience);
    }


    public List<EducationExperienceDto> getAllEducationExperienceById(Integer studentId) {
        List<EducationExperience> educationExperiences = educationExperienceRepository.findByStudentId(studentId);
        return educationExperienceMapper.toDtos(educationExperiences);
    }

    public void updateEducationExperienceById(Integer educationExperienceId, EducationExperienceDto educationExperienceDto) {
        EducationExperience educationExperience = educationExperienceRepository.getById(educationExperienceId);
        educationExperienceMapper.updateEntity(educationExperienceDto,educationExperience);
//        educationExperience.setStartDate(educationExperience.getStartDate());
//        educationExperience.setEndDate(educationExperience.getEndDate());
//        educationExperience.setSchool(educationExperience.getSchool());
//        educationExperience.setDegree(educationExperience.getDegree());
        educationExperienceRepository.save(educationExperience);

    }

    public void removeEducationById(Integer studentId) {
        educationExperienceRepository.deleteById(studentId);
    }


}
