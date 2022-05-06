package com.example.demo.domain.internshipopportunity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternshipOpportunityRepository extends JpaRepository<InternshipOpportunity, Integer> {
    @Query("select i from InternshipOpportunity i where i.user.id = ?1")
    List<InternshipOpportunity> findByUserId(Integer id);
}