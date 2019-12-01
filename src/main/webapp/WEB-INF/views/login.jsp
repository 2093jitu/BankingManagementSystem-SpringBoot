<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
</head>
<body>
	<center>
		<h1>Banking Managment System Login Page</h1>
		<hr></hr>
		<div style="margin-top: 100px"></div>
		<form action="/sinin" method="post">
			<table>
				<tr>
					<th>Account No</th>
					<td><input type="text" name="accountNo"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Login" class="btn btn-light"></th>					
				</tr>
				<tr>
					<th></th>
					<th><a href="/createAccount" class="btn btn-light">Create New</a></th>
				</tr>				
			</table>

		</form>

	</center>
</body>
</html>