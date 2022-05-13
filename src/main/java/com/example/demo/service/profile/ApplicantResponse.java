package com.example.demo.service.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantResponse {
    private Integer studentId;
    private Integer profileId;
    private String firstName;
    private String lastName;

}
