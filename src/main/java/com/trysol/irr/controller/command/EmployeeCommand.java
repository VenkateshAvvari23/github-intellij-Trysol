package com.trysol.irr.controller.command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeCommand {

    private String name;

    private String technology;

    private Double experience;

    private String email;

    private List<ArrayList> skillSet;

    private LocalDate aggrementStartDate;

    private LocalDate aggrementEndDate;

    private String client;

    private Long projectDuration;

}
