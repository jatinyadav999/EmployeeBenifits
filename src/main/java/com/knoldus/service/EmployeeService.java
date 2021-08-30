package com.knoldus.service;

import com.knoldus.entity.Employee;
import com.knoldus.exception.EmployeeException;
import com.knoldus.model.EmployeeModel;
import com.knoldus.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    
    public UUID saveEmployee(EmployeeModel employeeModel) throws Exception{
      UUID   token = generateUuid();
        Employee employee = new Employee();
        employee.setId(employeeModel.getId());
        employee.setName(employeeModel.getName());
        employee.setDept(employeeModel.getDept());
        employee.setEmail(employeeModel.getEmail());
        String employeeEmail = employee.getEmail();
        String regexEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        if(employeeEmail.matches(regexEmail)) {
            employee.setToken(token);
        }
        else{
          throw new EmployeeException("Please Provide The Valid Email");
        }

        employeeRepository.save(employee);
                 return  token;
    }

    public UUID generateUuid(){
       UUID randomUuid =  UUID.randomUUID();
       return randomUuid;

    }

}
