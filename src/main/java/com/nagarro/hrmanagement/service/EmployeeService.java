package com.nagarro.hrmanagement.service;

import java.util.List;

import com.nagarro.hrmanagement.models.Employee;

public interface EmployeeService {

	public Employee fetchEmployeeById(int id) throws Exception;

	public List<Employee> fetchAllEmployees() throws Exception;

	public String addEmployees(Employee employee) throws Exception;

	public String updateEmployeeDetails(Employee object, long id)throws Exception;

	public String fetchAllEmployeesFile() throws Exception;
}
