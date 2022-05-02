package com.example.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where upper(u.userName) = upper(?1)")
    User findByUserName(String userName);

    @Query("select (count(u) > 0) from User u where upper(u.userName) = upper(?1)")
    boolean existsByUserName(String userName);

    @Query("select u from User u where u.userName = ?1 and u.password = ?2")
    Optional<User> findByUserNameAndPassword(String userName, String password);



//    @Query("select u from User u where upper(u.userName) = upper(?1) and upper(u.password) = upper(?2)")
//    User findByUserNameAndPassword(String userName, String password);
//







}