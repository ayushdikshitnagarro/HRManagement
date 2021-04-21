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
#header {
	background-image: linear-gradient(blue, white);
}

#footer {
	position: absolute;
	bottom: 0;
	height: 100px;
	width: 1550px;
	bottom: 0;
	background-image: linear-gradient(white, blue);
}
</style>
</head>
<body style="background-color: white;">


	<%
		HRModel user = (HRModel) session.getAttribute("user");
	%>
	<div id="header" class="header">

		<div class="container mt-3">
			<h1 style="text-align: center">EMPLOYEE MANAGEMENT PORTAL</h1>
			<h1 align="right">Welcome ${user.getUsername()}</h1>
			<a href="logout" class="navbar-brand" style="float: right;"> <img
				src="https://www.recyclenow.com/sites/files/recyclenow/styles/large/public/media_wysiwyg/red-cross-md_0.png?itok=2QWhpuCq"
				alt="alternate_text" width="50px" height="50px">
			</a>
		</div>
	</div>
	<div class="container mt-5">
		<fieldset class="border p-3 " style="margin-top: 30px;">
			<legend class="w-auto" style="color: blue;">Employee Listing</legend>
			<div class="mt-6" style="margin-left: 500px;">
				<a href="addemployee">Upload Employee Details</a> <a
					style="margin-left: 100px;" href="downloadData">Download
					Employee Details</a>
			</div>
			<div>

				<div class="container" style="margin-top: 20px">
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="col">Employee Code</th>
								<th scope="col">Employee Name</th>
								<th scope="col">Location</th>
								<th scope="col">Email</th>
								<th scope="col">Date Of Birth</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>

							<c:if test="${employees== null}">
								<tr>
									<td></td>
									<td></td>
									<td>No Content Found</td>
								</tr>

							</c:if>
							<c:forEach var="emp" items="${employees}">
								<tr>

									<td><c:out value="${emp.employeeCode}" /></td>
									<td><c:out value="${emp.employeeName}" /></td>
									<td><c:out value="${emp.location}" /></td>
									<td><c:out value="${emp.email}" /></td>
									<td><c:out value="${emp.dateOfBirth}" /></td>
									<td>
										<form action="fetcheditpage" method="get">
											<input type="hidden" id="employeeCode" name="employeeCode"
												value=<c:out value="${emp.employeeCode}" />> <input
												type="submit" value="Edit Details">
										</form>
									</td>
									<td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
				</div>
		</fieldset>
	</div>
	<div id="footer" class="footer">
		<h1></h1>
	</div>
</body>
</html>