<jsp:include page="navber.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center>
	<h1 style="margin-top: 30px">Balance Transaction</h1>
	<hr></hr>
	<div style="margin-top: 100px"></div>

	<table class="table table-bordered" style="width: 45%">
		<tr>
			<th>Name</th>
			<th>Account No</th>
			<th>MIRC No</th>
			<th>Balance</th>
		</tr>
		<c:forEach var="balance" items="${allBalance}">
			<tr>				
				<td>${balance.name}</td>
				<td>${balance.accountNo}</td>
				<td>${balance.mircNo}</td>
				<td>${balance.ammount}</td>
			</tr>
		</c:forEach>
	</table>

</center>