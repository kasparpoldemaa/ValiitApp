package com.example.demo.requiredtechnology;

import com.example.demo.internshipopportunity.InternshipOpportunity;
import com.example.demo.technology.Technology;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "required_technology")
public class RequiredTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "internship_opportunity_id", nullable = false)
    private InternshipOpportunity internshipOpportunity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technology_id", nullable = false)
    private Technology technology;

}