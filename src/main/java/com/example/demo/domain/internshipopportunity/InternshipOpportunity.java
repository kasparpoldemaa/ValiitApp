package com.example.demo.domain.internshipopportunity;

import com.example.demo.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "internship_opportunity")
public class InternshipOpportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "location")
    private String location;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "is_payable", nullable = false)
    private Boolean isPayable = false;

    @Column(name = "number_of_positions")
    private String numberOfPositions;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "technology", nullable = false, length = 500)
    private String technology;

    @Column(name = "work_type", nullable = false, length = 500)
    private String workType;

}