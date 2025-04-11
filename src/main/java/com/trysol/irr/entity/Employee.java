package com.trysol.irr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sNo")
    private Long sNo;

    @Column(name ="Mode")
    private String mode;

    @Column(name = "Name")
    private String name;

    @Column(name = "Skill")
    private String skill;

    @Column(name = "ProjectShadow")
    private String projectShadow;

    @Column(name = "Experience")
    private Double experience;

    @Column(name = "NDA")
    private String nda;

    @Column(name ="CVReady")
    private String cvReady;

    @Column(name = "linkedIn")
    private String linkedIn;

    @JsonFormat(pattern= "YYYY-MM-dd")
    @Column(name = "DateOfNDA")
    private String dateOfNDA;

    @Column(name = "Notary")
    private String notary;

    @Column(name = "Affidavit")
    private String affidavit;

    @Column(name = "Salaryonddeployed")
    private Double salaryOnDeployed;

    @Column(name = "Salary")
    private Double salaryOnBench;

    @Column(name = "Readytotravel" )
    private String readyToTravel;

    @Column(name= "Email")
    private String email;

    @Column(name = "Mobilenum")
    private Long mobileNo;


}
