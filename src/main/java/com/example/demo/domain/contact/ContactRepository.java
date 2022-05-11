package com.example.demo.domain.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("select c from Contact c where c.user.id = ?1")
    Contact findByUser_Id(Integer id);

    @Query("select c from Contact c where c.user.id = ?1")
    Contact getContact(Integer id);
}