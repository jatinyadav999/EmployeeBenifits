package com.knoldus.service;

import com.knoldus.entity.Employee;
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
    public String saveEmployee(Employee employee){
        employeeRepository.save(employee);
        String random = generateUuid();
        System.out.println("randomOne=========="+random);
        return  generateUuid();
    }

    public String generateUuid(){
       String randomUuid =  UUID.randomUUID().toString();
       return randomUuid;

    }

}
