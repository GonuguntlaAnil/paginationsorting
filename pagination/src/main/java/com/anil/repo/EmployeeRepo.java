package com.anil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
