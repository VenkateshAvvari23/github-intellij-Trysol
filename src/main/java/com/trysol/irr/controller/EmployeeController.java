package com.trysol.irr.controller;


import com.trysol.irr.Exception.UserAlreadyExistsException;
import com.trysol.irr.Exception.UserNotFound;
import com.trysol.irr.controller.command.EmployeeCommand;
import com.trysol.irr.entity.Employee;
import com.trysol.irr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<String> create(@RequestBody EmployeeCommand employeeCommand)throws UserAlreadyExistsException {

        String response = employeeService.create(employeeCommand);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)throws UserNotFound {

        String response = employeeService.deleteId(id);
        return new ResponseEntity<>(response,HttpStatus.OK);


    }
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody EmployeeCommand employeeCommand){


        return  employeeService.update(id,employeeCommand);

    }

}
