<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.nagarro.hrmanagement.models.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<style>
.formadjust {
	align-content: center;
}
.center_div {
	margin: 0 auto;
	width: 90%;
	
}
#header{
background-image: linear-gradient(blue, white);}
#footer{
 bottom:0;
background-image: linear-gradient(white,blue);
}
</style>

</head>
<body style="background-color: white;">

	
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	HRModel user = (HRModel) session.getAttribute("user");
	String userinfo=(String) session.getAttribute("userinfo");
	%>

	
	<div id="header" class="header container mt-3">
	<h3 class="text-info" style=" margin-left: 280px" >EMPLOYEE MANAGEMENT PORTAL</h3>
		<h5 align="right">Welcome ${user.getUsername()}</h5> 
		 <a href = "logout" class = "navbar-brand" style="float:right;"> Logout </a>
	</div>

	<div class="container mt-5">
		<fieldset class="border p-3 " style="margin-top: 30px;">
			<legend class="w-auto" style="color: blue;">ADD NEW EMPLOYEE</legend>
			
			<div>

				<div class="container" style="margin-top: 20px">
					<form action="AddEmployee" class="formadjust" method="post" class="mt-10">
						<div class=" container center_div">
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Employee Code </label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="employeeCode"
										placeholder="Employee Code">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Employee Name</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="employeeName"
										placeholder="Employee Name" pattern=".{1,100}" required title="min 1 max 100 characters">
								</div>
							</div>
		
							<div class="form-group row">
								<label class="col-sm-2 col-form-label"> Location</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="location"
										placeholder="Employee Location" pattern=".{5,500}" required title="min 5 max 500 characters">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label"> Email</label>
								<div class="col-sm-5">
									<input type="email" class="form-control" name="email"
										placeholder="Employee Email" pattern=".{10,100}" required title="min 10 max 100 characters">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label"> Date of Birth </label>
								<div class="col-sm-5">
									<input type="date" class="form-control" name="dateOfBirth"
										 placeholder="dd/mm/yyyy"  min="1997-01-01" max="2030-12-31">
								</div>
							</div>
							<br>
							<div>
							<h5> ${userinfo}</h5>
							
							</div>
		
							<div class="form-group row">
								<div class="col-sm-5">
									<button style="margin:15px;" type="submit" class="btn btn-primary">Save</button>
									<button style="margin-left:5px;" type="clear" class="btn btn-primary">Cancel</button>
								</div>
							</div>
		
						</div>
					</form>
				</div>
		
		</fieldset>
	</div>
	<div id="footer" class="footer">
<h1>.</h1>
</div>
</body>
</html>