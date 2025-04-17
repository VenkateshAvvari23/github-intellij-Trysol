package com.trysol.irr.service;

import com.trysol.irr.Exception.IllegalArgumentException;
import com.trysol.irr.Exception.UserAlreadyExistsException;
import com.trysol.irr.Exception.UserNotFound;
import com.trysol.irr.controller.command.EmployeeCommand;
import com.trysol.irr.controller.command.RegisterCommand;
import com.trysol.irr.entity.Employee;
import com.trysol.irr.entity.User;

public interface EmployeeService {

    public String create(EmployeeCommand employeeCommand)throws UserAlreadyExistsException;

    public String deleteId(Long id)throws UserNotFound;

    public Employee update(Long id, EmployeeCommand EmployeeCommand);

   // public String register(EmployeeCommand employeeCommand) throws UserAlreadyExistsException, IllegalArgumentException;

}
