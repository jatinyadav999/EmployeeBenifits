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
    public String saveEmployee(EmployeeModel employeeModel) throws Exception{
        String token = generateUuid();
        Employee employee = new Employee();
        employee.setId(employeeModel.getId());
        employee.setName(employeeModel.getName());
        employee.setDept(employeeModel.getDept());
        employee.setEmail(employeeModel.getEmail());
        String employeeEmail = employee.getEmail();
        if(employeeEmail.contains("@gmail.com")) {
            employee.setToken(token);
        }
        else{
          throw new EmployeeException("Please Provide The Valid Email");
        }
        employeeRepository.save(employee);
        return  token;
    }

    public String generateUuid(){
       String randomUuid =  UUID.randomUUID().toString();
       return randomUuid;

    }

}
