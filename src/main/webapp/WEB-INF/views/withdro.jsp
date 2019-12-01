<jsp:include page="navber.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center>
	<h1 style="margin-top: 30px">Withdro Page</h1>
	<hr></hr>	
	<div style="margin-top: 100px"></div>
	<form action="/showbalance" method="post">
		<table>
			<tr>
				<th>User</th>
				<td><input type="text" name="name" /></td>
				<td><input type="submit" value="Search" /></td>							
			</tr>
			</form>
			<form action="/totalamount" method="post">
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="${balance.name}" /></td>
				<input type="hidden" name="id" value="${balance.id}"/>	
			</tr>
			<tr>
				<th>Account No</th>
				<td><input type="text" name="accountNo" value="${balance.accountNo}"/></td>				
			</tr>
			<tr>
				<th>Available Balance</th>
				<td><input type="number" name="ammount" value="${balance.ammount}"/></td>				
			</tr>
			<tr>
				<th>Amount</th>
				<td><input type="number" name="wbalance" /></td>				
			</tr>
			<tr>
				<th>Total</th>
				<td><input type="number" name="tammount" value="${tammount}"/></td>
				
				<td><input type="submit" value="Total" /></td>
				<td>				
				<c:if test="${tammount<1}">
					<p>You Have Not Available Balance</p>
				</c:if>
				</td>				
			</tr>
			</form>
			<tr>
				<td><input value="${id}" name="id" type="hidden"/></td>
				<td><a href="withdrow/${tammount}/${id}" class="btn btn-light">Withdrow</a></td>
				<td></td>
			</tr>
		</table>
		<c:if test="${msg}">
			<p>Withdrow Successfull</p>
		</c:if>	

</center>
