package com.knoldus;

import com.knoldus.entity.Employee;
import com.knoldus.model.EmployeeModel;
import com.knoldus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public String saveEmployee(@RequestBody EmployeeModel employeeModel) throws Exception{
        return employeeService.saveEmployee(employeeModel);
    }
}
