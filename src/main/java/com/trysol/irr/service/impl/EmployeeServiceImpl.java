package com.trysol.irr.service.impl;

import com.trysol.irr.Exception.UserAlreadyExistsException;
import com.trysol.irr.Exception.UserNotFound;
import com.trysol.irr.controller.command.EmployeeCommand;
import com.trysol.irr.entity.Employee;
import com.trysol.irr.repository.EmployeeRepository;
import com.trysol.irr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public String create(EmployeeCommand employeeCommand) throws UserAlreadyExistsException{

        Optional<Employee> user = employeeRepository.findByEmail(employeeCommand.getEmail());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + employeeCommand.getEmail() + " already exists.");
        }

        else {

            employeeRepository.save(getEmployeeEntity(employeeCommand));
            return "Created Successfully";

        }
    }
    private Employee getEmployeeEntity(EmployeeCommand employeeCommand) {

        return Employee.builder().mode(employeeCommand.getMode())
                .name(employeeCommand.getName())
                .skill(employeeCommand.getSkill())
                .projectShadow((employeeCommand.getProjectShadow()))
                .experience(employeeCommand.getExperience())
                .nda(employeeCommand.getNda())
                .cvReady(employeeCommand.getCvReady())
                .linkedin(employeeCommand.getLinkedin())
                .dateOfNDA((employeeCommand.getDateOfNDA()))
                .notary(employeeCommand.getNotary())
                .affidavit(employeeCommand.getAffidavit())
                .salaryOnDeployed(employeeCommand.getSalaryOnDeployed())
                .salaryOnBench(employeeCommand.getSalaryOnBench())
                .readyToTravel(employeeCommand.getReadyToTravel())
                .email(employeeCommand.getEmail())
                .mobileNum(employeeCommand.getMobileNum())
                .build();

    }

    public String deleteId(Long id) throws UserNotFound {
        if (id == null || !employeeRepository.existsById(id)) {
            throw new UserNotFound("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }



    public Employee update(Long id, EmployeeCommand employeeCommand) {



        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);

        if(existingEmployeeOpt.isEmpty()){

            throw new UserNotFound("Employee not found with id: " + id);
        }

        Employee existingUser = existingEmployeeOpt.get();

        // Get updated fields from command
        Employee updatedEmployee = getEmployeeEntity(employeeCommand);

        // Preserve original ID and any other immutable fields
        updatedEmployee.setSNo(existingUser.getSNo());

        return employeeRepository.save(updatedEmployee);



    }

}
