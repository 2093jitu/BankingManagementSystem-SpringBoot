<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1 style="margin-top: 30px">Create A New Account</h1>
		<form action="create" method="post">
			<table>
				<tr>
					<th>Account No</th>
					<td><input type="number" name="accountNo"  value="${accountNo}"/></td>
				</tr>
				<tr>
					<th>Mric No</th>
					<td><input type="number" name="mircNo" value="${mircNo}"/></td>
				</tr>
				<tr>
					<th>Pin</th>
					<td><input type="number" name="pinNo" value="${pinNo}"/></td>
				</tr>
				<tr>
					<th>Gender</th>
					<td><input type="radio" name="gender" value="male" />Male <input
						type="radio" name="gender" value="female" />FeMale</td>
				</tr>
				<tr>
					<th>Account Type</th>
					<td><select name="accountType">
							<option>Runing</option>
							<option>Saving</option>
					</select></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<th>Ammount</th>
					<td><input type="text" name="ammount" /></td>
				</tr>
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<th>Date Of Birth</th>
					<td><input type="text" name="dob" /></td>
				</tr>
				<tr>
					<th>nationality</th>
					<td><select name="nationality">
							<option>bangladesh</option>
							<option>India</option>
					</select></td>
				</tr>
				<tr>
					<th>Cast</th>
					<td><input type="text" name="cast" /></td>
				</tr>
				<tr>
					<th>Mobile No</th>
					<td><input type="text" name="phon" /></td>
				</tr>
				<tr>
					<th>Sequerity Qus</th>
					<td><select name="sQus">
							<option>what is your name</option>
					</select></td>
				</tr>
				<tr>
					<th>Annser</th>
					<td><input type="text" name="ans" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Create" /></td>
				</tr>
			</table>
		</form>
		<a href="/">Back</a>
	</center>
</body>
</html>