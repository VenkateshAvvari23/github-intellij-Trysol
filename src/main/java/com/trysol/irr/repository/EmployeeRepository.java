package com.trysol.irr.repository;

import com.trysol.irr.entity.Employee;
import com.trysol.irr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEmail(String email);
}
