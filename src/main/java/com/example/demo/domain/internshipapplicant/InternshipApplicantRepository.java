package com.example.demo.domain.internshipapplicant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternshipApplicantRepository extends JpaRepository<InternshipApplicant, Integer> {
    @Query("select count(i) from InternshipApplicant i where i.internshipOpportunity.id = ?1")
    long countByInternshipOpportunity_Id(Integer id);

    @Query("select i from InternshipApplicant i where i.internshipOpportunity.id = ?1")
    List<InternshipApplicant> findByInternshipOpportunity_Id(Integer id);

    @Query("select i from InternshipApplicant i where i.internshipOpportunity.id = ?1")
    List<InternshipApplicant> getOpportunityList(Integer id);

    @Query("select i from InternshipApplicant i where i.student.id = ?1")
    List<InternshipApplicant> findByStudentId(Integer id);





}