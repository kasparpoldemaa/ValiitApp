package com.example.demo.domain.student;

import com.example.demo.domain.studentprofile.StudentProfileDto;
import com.example.demo.domain.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {
    private Integer id;
    private UserDto user;
    private StudentProfileDto studentProfile;
    private Boolean isAvailable;
}
