package com.example.demo.domain.workexperience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {
    @Query("select w from WorkExperience w where w.student.id = ?1")
    List<WorkExperience> findByStudentId(Integer id);




}