package com.example.demo.domain.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("select u from UserRole u where upper(u.user.userName) = upper(?1)")
    UserRole findByUser_UserNameIgnoreCase(String userName);



}