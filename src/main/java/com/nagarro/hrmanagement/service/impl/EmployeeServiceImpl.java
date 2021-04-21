package com.nagarro.hrmanagement.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.hrmanagement.models.Employee;
import com.nagarro.hrmanagement.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RestTemplate restTemplate;

	private final String EMPLOYEES_URL = "http://localhost:8181/employees";
	private final String EMPLOYEE = "http://localhost:8181/employee";

	public Employee fetchEmployeeById(int id) throws Exception {
		final String uri = EMPLOYEE + "/" + id;
		String result = restTemplate.getForObject(uri, String.class);
		return new ObjectMapper().readValue(result, Employee.class);
	}

	public List<Employee> fetchAllEmployees() throws Exception {
		try {
			ResponseEntity<String> entity = restTemplate.getForEntity(EMPLOYEES_URL, String.class);

			String body = entity.getBody();
			HttpStatus statusCode = entity.getStatusCode();

			if (statusCode == HttpStatus.NO_CONTENT) {
				System.out.println(statusCode + " " + body);
				return null;
			}
			Employee[] users = new ObjectMapper().readValue(body, Employee[].class);

			return Arrays.asList(users);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public String addEmployees(Employee employee) throws Exception {

		ObjectMapper m = new ObjectMapper();
		String json = m.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		try {

			ResponseEntity<String> response = restTemplate.postForEntity(EMPLOYEE, json, String.class);
			return response.getStatusCode().toString();

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String updateEmployeeDetails(Employee object, long id) throws Exception {
		final String uri = EMPLOYEE + "/" + id;

		ObjectMapper m = new ObjectMapper();
		String json = m.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		try {

			ResponseEntity<String> response = restTemplate.postForEntity(uri, json, String.class);
			return response.getStatusCode().toString();

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String fetchAllEmployeesFile() throws IOException {
		final String uri = EMPLOYEES_URL;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, String.class);
	}
}
