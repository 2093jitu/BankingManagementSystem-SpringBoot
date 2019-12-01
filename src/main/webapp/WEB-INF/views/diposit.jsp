<jsp:include page="navber.jsp"></jsp:include>
<center>
	<h1 style="margin-top: 30px">Diposit Page</h1>
	<hr></hr>
	<div style="margin-top: 100px"></div>
	<table>
		<form action="/dipositSerch">
		<tr>
			<th>User</th>
			<td><input type="text" name="name" placeholder="Enter User Name" /></td>
			<td><input type="submit" value="search" /></td>
		</tr>

		</form>
		<form action="/dipositb" method="post">

			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="${balance.name}" /></td>
			</tr>
			<tr>
				<th>Account No</th>
				<td><input type="text" name="accountNo"
					value="${balance.accountNo}" /></td>

			</tr>
			<tr>
				<th>Avable Balance</th>
				<td><input type="text" name="ammount"
					value="${balance.ammount}" /></td>

			</tr>
			<input type="hidden" name="id" value="${balance.id}"  />
			<tr>
				<th>Deposit Ammount</th>
				<td><input type="number" name="damount" /></td>

				<td><input type="number" name="tammount" value="${tammount}" /></td>

				<td><input type="submit" value="Total" /></input></td>
			</tr>
		</form>
		<tr>
			<input type="hidden" name="id" value="${id}" />
			<th></th>
			<td></td>
			<td><a href="/totalammount/${tammount}/${id}"
				class="btn btn-light">Diposit</a></td>
		</tr>
	</table>
</center>
<!-- <script>
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope, $http) {		
		$scope.dammount='';
		$scope.total = function() {
			$scope.tammount=$scope.dammount;
			console.log($scope.dammount);

		}
	});
</script> -->