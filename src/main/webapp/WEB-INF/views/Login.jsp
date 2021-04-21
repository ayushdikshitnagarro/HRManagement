<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

#footer {	position: absolute;
	bottom: 0;
	height: 100px;
	width: 1550px;
	bottom: 0;
	background-image: linear-gradient(white, blue);
}
</style>


</head>
<body style="background-color: white;">

	<div id="header" class="header">
		<h1 style="text-align:center">EMPLOYEE MANAGEMENT PORTAL</h1>
	</div>


	<div class="container mt-5">
		<fieldset class="border p-3 " style="margin-top: 30px;">
			<legend class="w-auto" style="color: blue;">LOGIN</legend>
			<div>

				<div class="container" style="margin-top: 20px">
					<form action="login" method="post">


						<div class="form-group row" style="margin-top: 50px">
							<label for="username" class="col-sm-2 col-form-label">User
								Id: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" placeholder="Username"
									required="required" name="username" />
							</div>
						</div>
						<div class="form-group row">
							<label for="Password" class="col-sm-2 col-form-label">Password:
							</label>
							<div class="col-sm-5">
								<input type="password" class="form-control"
									placeholder="Password" required="required" name="password" />
							</div>
						</div>

						<div class="form-group row footer">
							<button type="submit" class="btn btn-primary">LOGIN</button>
						</div>
					</form>
				</div>
		</fieldset>
	</div>
	<div id="footer" class="footer">
		<h1></h1>
	</div>

</body>
</html>