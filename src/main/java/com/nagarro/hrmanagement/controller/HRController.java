package com.nagarro.hrmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanagement.constants.Constants;
import com.nagarro.hrmanagement.dao.HRDao;
import com.nagarro.hrmanagement.dao.impl.HRDaoImpl;
import com.nagarro.hrmanagement.models.Employee;
import com.nagarro.hrmanagement.models.HRModel;
import com.nagarro.hrmanagement.service.EmployeeService;
import com.nagarro.hrmanagement.service.HRService;
import com.nagarro.hrmanagement.service.impl.EmployeeServiceImpl;

@Controller
public class HRController {

	@Autowired
	private HRService hrService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String home() {
		return Constants.LOGIN_PAGE;
	}

	@RequestMapping(Constants.LOGIN_HOME_URL)
	public ModelAndView login(@ModelAttribute HRModel hr, HttpServletRequest request) throws Exception {
		String username = hr.getUsername();
		String password = hr.getPassword();
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		HRModel user = hrService.getUserDetails(username);
		if (hr != null && user.getPassword().equals(password)) {

			try {
				List<Employee> employees;
				employees = employeeService.fetchAllEmployees();
				session.setAttribute(Constants.USER, user);
				model.addObject(Constants.EMPLOYEES, employees);
				model.setViewName(Constants.EMPLOYEE_LIST_PAGE);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			model.setViewName(Constants.LOGIN_PAGE);
		}
		return model;
	}

	@RequestMapping(Constants.LOGOUT_URL)
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		req.getSession().removeAttribute(Constants.USER);
		req.getSession().invalidate();
		res.sendRedirect(Constants.LOGIN_URL);
	}

}
