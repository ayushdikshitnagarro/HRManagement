package com.nagarro.hrmanagement.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.hrmanagement.constants.Constants;
import com.nagarro.hrmanagement.models.Employee;
import com.nagarro.hrmanagement.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServices;

	@RequestMapping(Constants.MAIN_LOGIN)
	public String login() {
		return Constants.LOGIN_PAGE;
	}

	@RequestMapping(Constants.VIEW_EMPLOYEE_URL)
	public String fetchEmployeeList(ModelMap m) throws Exception {
		m.addAttribute(Constants.EMPLOYEES, employeeServices.fetchAllEmployees());
		return Constants.EMPLOYEE_LIST_PAGE;
	}

	@RequestMapping(Constants.ADDEMPLOYEE_URL)
	public String fetchNewDetails(HttpServletRequest req, HttpServletResponse res) {
		return Constants.ADD_EMPLOYEE_PAGE;
	}

	@RequestMapping(value = Constants.ADDEMPLOYEE_URL2, method = RequestMethod.POST)
	public void addEmployeeDetails(@ModelAttribute Employee employee, HttpServletResponse res) throws Exception {

		String d[] = employee.getDateOfBirth().split("-");
		String temp = "";
		temp += d[2] + "/" + d[1] + "/" + d[0];
		employee.setDateOfBirth(temp);
		String employees = employeeServices.addEmployees(employee);
		ModelAndView m = new ModelAndView();
		m.addObject(Constants.USER_INFO, Constants.EMPLOYEE_ADDED_MSG);
		PrintWriter out = res.getWriter();
		out.println(Constants.SCRIPT_1);
		if (employees.equals("201 CREATED")) {
			out.println(Constants.SCRIPT_2);
		} else {
			out.println(Constants.SCRIPT_5);
		}

		out.println(Constants.SCRIPT_3);
		out.println(Constants.SCRIPT_4);
	}

	@RequestMapping(Constants.VIEW_EDIT_PAGE_URL)
	public String fetchEditPage(HttpServletRequest req, ModelMap m) throws Exception {
		int id = Integer.parseInt(req.getParameter(Constants.EMPLOYEE_CODE));
		Employee employeeById = employeeServices.fetchEmployeeById(id);
		m.addAttribute(Constants.EMPLOYEE_BY_ID, employeeById);
		return Constants.EDIT_EMPLOYEE_PAGE;
	}

	@RequestMapping(Constants.EDITEMPLOYEE_URL)
	public void updateEmployee(@ModelAttribute Employee employee, ModelMap m, HttpServletResponse res)
			throws Exception {
		long eid = employee.getEmployeeCode();
		String d[] = employee.getDateOfBirth().split("-");
		String temp = "";
		temp += d[2] + "/" + d[1] + "/" + d[0];
		employee.setDateOfBirth(temp);

		String updateEmployeeDetails = employeeServices.updateEmployeeDetails(employee, eid);
		PrintWriter out = res.getWriter();
		out.println(Constants.SCRIPT_1);

		out.println(Constants.SCRIPT_2);

		out.println(Constants.SCRIPT_3);
		out.println(Constants.SCRIPT_4);

		m.addAttribute(Constants.EMPLOYEES, employeeServices.fetchAllEmployees());

	}

	@RequestMapping(Constants.DOWNLOAD_URL)
	public void downloadData(HttpServletRequest req, HttpServletResponse response) throws Exception {
	
		response.setContentType(Constants.CONTENT_TYPE);
		response.addHeader(Constants.CONTENT_DISPOSION, Constants.ATTACHMENT);
		try (ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.EXCEL_PREFERENCE)) {
			List<Employee> employees = employeeServices.fetchAllEmployees();
			csvBeanWriter.writeHeader(Constants.CSV_HEADER);
			for (Employee employee : employees) {
				csvBeanWriter.write(employee,Constants.CSV_HEADER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
