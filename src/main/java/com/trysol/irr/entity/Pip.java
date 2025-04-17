package com.trysol.irr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pip {


    @Column(name = "Name")
    private String name;

    @Column(name="PIP No")
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pip;

    @Column(name="Mobile No")
    private String mobile;

    @Column(name="Email ID")
    private String emailId;

    @Column(name="Technology")
    private String technology;

    @Column(name = "DOJ")
    private LocalDate dateOfJoining;

    @Column(name = "PIP Charges")
    private double pipCharges;

    @Column(name ="Salary")
    private double salary;

    @Column(name = "Referred By")
    private String referredBy;



}
