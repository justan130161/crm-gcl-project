package com.gcl.crm.service;

import com.gcl.crm.entity.Employee;
import com.gcl.crm.enums.EmployeeStatus;
import com.gcl.crm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllWorkingEmployees() {
        List<Employee> employees = employeeRepository.findAllByStatusNot(EmployeeStatus.OFF_WORKING);
        return employees;
    }
}
