package com.nagarro.hrmanagement.constants;

public class Constants {

	public static final String LOGIN_PAGE = "Login";
	public static final String VERIFIED="Verified..";
	public static final String USER = "user";
	public static final String EMPLOYEES="employees";
	public static final String EMPLOYEE_LIST_PAGE = "EmployeeList";
	public static final String LOGIN_AGAIN="Please Check the Username and Password..!";
	public static final String ADD_EMPLOYEE_PAGE = "AddEmployee";
	public static final String USER_INFO="userinfo";
	public static final String EMPLOYEE_ADDED_MSG="Employee Added Successfully ..!";
	public static final String SCRIPT_1="<script type=\"text/javascript\">";
	public static final String SCRIPT_2="alert('Employee Added Successfully ..!');";
	public static final String SCRIPT_3="location='/HRManagement/OpenEmployeeList';";
	public static final String SCRIPT_5="alert('Employee Cant be Added ..!');";
	public static final String SCRIPT_4="</script>";
	public static final String EMPLOYEE_CODE="employeeCode";
	public static final String EMPLOYEE_BY_ID="employeeById";
	public static final String EDIT_EMPLOYEE_PAGE="EditEmployee";
	public static final String LOGIN_URL="Login";
	public static final String EMPLOYEE_UPDATED_MSG="Employee Updated..!";
	public static final String APPLICATION_TYPE= "application/json";
	
	public static final String LOGIN_HOME_URL="/login";
	public static final String LOGOUT_URL="/logout";
	public static final String ADDEMPLOYEE_URL="/addemployee";
	public static final String ADDEMPLOYEE_URL2="/AddEmployee";
	public static final String	VIEW_EMPLOYEE_URL="/OpenEmployeeList";
	public static final String VIEW_EDIT_PAGE_URL="/fetcheditpage";
	public static final String EDITEMPLOYEE_URL="/editemployee";
	public static final String DOWNLOAD_URL="/downloadData";
	public static final String MAIN_LOGIN="/Login";
	
	public static final String[] CSV_HEADER = { "employeeCode", "employeeName", "location", "email", "dateOfBirth" };
	public static final String CONTENT_DISPOSION="Content-Disposition";
	public static final String ATTACHMENT="attachment; filename=employeesInfo.csv";
	public static final String CONTENT_TYPE="text/csv";
}
