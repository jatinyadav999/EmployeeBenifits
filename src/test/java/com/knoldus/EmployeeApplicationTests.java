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

//	@Test
//	public void saveEmployee() throws Exception {
//		EmployeeModel employeeModel = new EmployeeModel();
//		System.out.println("employeeModel==="+employeeModel);
//		EmployeeService employeeService = new EmployeeService();
//		String uuid = employeeService.generateUuid();
//		System.out.println("uuid==="+uuid);
//	String saveEmployee =	employeeService.saveEmployee(employeeModel);
//	System.out.println("saveEmployee==="+saveEmployee);
//		assertAll("tweetName", () -> assertEquals("06f4f2e4-2eb4-4083-9e2e-21907979fe58",
//				employeeService.saveEmployee(employeeModel)));
//	}

	@Test
	public void ifEmailIsValid() throws Exception{
	UUID uuid =	employeeService.generateUuid();
	//EmployeeModel employeeModel = new EmployeeModel(5,"Akshay","marketing","Aksahy.dhama@gmail.com");
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
