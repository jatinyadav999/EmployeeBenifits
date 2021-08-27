package com.knoldus;

import com.knoldus.entity.Employee;
import com.knoldus.model.EmployeeModel;
import com.knoldus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employee/registration")
    public UUID saveEmployee(@RequestBody EmployeeModel employeeModel) {
        UUID uuid = null;
        try {
            uuid = employeeService.saveEmployee(employeeModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uuid;

    }

}
