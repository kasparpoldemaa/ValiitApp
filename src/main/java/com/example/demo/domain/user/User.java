package com.example.demo.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

}