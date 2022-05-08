package com.example.demo.domain.educationexperience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationExperienceRepository extends JpaRepository<EducationExperience, Integer> {
    @Query("select e from EducationExperience e where e.student.id = ?1")
    List<EducationExperience> findByStudentId(Integer id);
}