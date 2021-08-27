package com.knoldus;

import com.knoldus.entity.Employee;
import com.knoldus.exception.EmployeeException;
import com.knoldus.model.EmployeeModel;
import com.knoldus.repository.EmployeeRepository;
import com.knoldus.service.EmployeeService;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {
	@MockBean
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;

	@Test
	void contextLoads() {
	}


	@Test
	public void ifEmailIsValid() throws Exception{
	UUID uuid =	employeeService.generateUuid();
		Employee employee = new Employee(5,"Akshay","marketing","akshay.dhama@gmail.com",uuid);
	 when(employeeRepository.save(employee)).thenReturn(employee);
	 assertEquals(uuid,employee.getToken());

	}
	@Test
	public void ifEmailIsNotValid() throws Exception{
		String message = "Please Provide The Valid Email";
		EmployeeException employeeException = new EmployeeException("Please Provide The Valid Email");
		Employee employee = new Employee(6,"AwaneeshDubey","Sales","awanees.dubey@byjus.com",null);
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(message,employeeException.getMessage());
	}



}
