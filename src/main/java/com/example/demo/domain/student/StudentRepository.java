package com.example.demo.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.isAvailable = ?1")
    List<Student> findByIsAvailable(Boolean isAvailable);

    @Query("select s from Student s where s.user.id = ?1")
    Student findByUser_Id(Integer id);




}