package com.trysol.irr.controller.command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeCommand {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
//    private Long sNo;

    private String mode;

    private String name;

    private String skill;

    private String projectShadow;

    private Double experience;

    private String nda;

    private String cvReady;

    private String linkedIn;

    private String dateOfNDA;

    private String notary;

    private String affidavit;

    private Double salaryOnDeployed;

    private Double salaryOnBench;

    private String readyToTravel;

    private String email;

    private Long mobileNo;

}
