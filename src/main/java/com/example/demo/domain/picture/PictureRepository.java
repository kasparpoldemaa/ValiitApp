package com.example.demo.domain.picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    @Query("select p from Picture p where p.student.id = ?1")
    Picture findByStudentId(Integer id);

    @Query("select (count(p) > 0) from Picture p where p.student.id = ?1")
    boolean existsByStudentId(Integer id);



}