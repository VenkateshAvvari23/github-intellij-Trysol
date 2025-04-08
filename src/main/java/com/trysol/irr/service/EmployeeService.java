package com.trysol.irr.service;

import com.trysol.irr.controller.command.EmployeeCommand;
import com.trysol.irr.entity.Employee;

public interface EmployeeService {

    public Employee create(EmployeeCommand employeeCommand);
}
