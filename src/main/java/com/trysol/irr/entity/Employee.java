package com.trysol.irr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Technology")
    private String technology;

    @Column(name = "Experience")
    private Double experience;

    @Column(name= "Email")
    private String email;

    @Column(name = "SkillSet")
    private List<ArrayList> skillSet;

    @Column(name = "AggrementStartDate")
    private LocalDate aggrementStartDate;

    @Column(name = "AggrementEtartDate")
    private LocalDate aggrementendDate;

    @Column(name = "Client")
    private String client;

    @Column(name = "ProjectDuration")
    private Long projectDuration;
}
