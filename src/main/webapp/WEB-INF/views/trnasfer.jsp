<jsp:include page="navber.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center ng-app="myApp" ng-controller="myCtrl">
	<h1 style="margin-top: 30px">Trnasfer Page</h1>
	<hr></hr>
	<div style="margin-top: 100px"></div>
	<c:if test="${error}">
		<p style="color: red;">You Selected Same Debit Account And Credit
			Account</p>
	</c:if>
	<c:if test="${success}">
		<p style="color: green;">Balance Trnasfer Successfull</p>
	</c:if>
	<p style="color: red;">{{msg}}</p>
	<form action="trnasferforshowbalance" method="post">
		<table>
			<tr>
				<th>User</th>
				<td><input type="text" name="name" required="required"
					placeholder="Enter User Name" /></td>
				<td><input type="submit" value="Search" class="btn btn-success" /></td>
			</tr>
			</form>
			<form action="trnasfarSubmit" method="post">
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" value="${balance.name}" />
					<td><input type="number" name="id" value="${balance.id}" />
				</tr>
				<tr>
					<th>Account No</th>
					<td><input type="text" name="accountNo"
						value="${balance.accountNo}" //>
					<td>
				</tr>
				<tr>
					<th>Available Balance</th>
					<td><input type="text" name="ammount"
						value="${balance.ammount}" />
					<td>
				</tr>

				<tr>
					<th>Trnsfer Amount</th>
					<td><input type="number" ng-model="tammount" name="tammount" />
					</td>
					<td><input type="text" ng-model="totalAmmount"
						placeholder="Debit Ac Current Bl" name="dTotalAmmount" /></td>
					<td><input type="button" value="Total"
						ng-click="totalamount()" class="btn btn-primary" /></td>
				</tr>
				<tr>
					<th>Credit Account</th>
					<td><select style="width: 100%" ng-model="selectedAc"
						ng-change="change()" name="selectedAccountNo">
							<option selected disabled="disabled">Select Credit
								Account No</option>
							<c:forEach var="no" items="${accountNo}">
								<option>${no}</option>
							</c:forEach>
					</select></td>
					<td><input type="text" ng-model="creadiAcBalance"
						name="creadiAcBalance" /></td>
					<td><input type="text" ng-model="creadiAcTotal"
						placeholder="Credit Ac Current Bl" name="creadiAcTotal" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Show"
						ng-click="cridetAcTotalNow()" class="btn btn-danger" /> <input
						type="submit" value="Trnasfer" class="btn btn-info" /></td>
				</tr>

			</form>
		</table>
</center>
<script>
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.masg = "Ok";
		$scope.tammount = '';
		$scope.totalAmmount = '';
		$scope.selectedAc = '';
		$scope.creadiAcBalance = '';
		$scope.creadiAcTotal = '';
		$scope.msg = '';
		$scope.trnasfer = {};
		$scope.totalamount = function() {

			$http.get('/tammount/' + this.tammount).then(function(res) {

				if (res.data > 1) {
					$scope.totalAmmount = res.data;
				} else {

					$scope.msg = 'You Have No Enafe balance For Tranasfer';

				}

			});
		}
		$scope.change = function() {
			//alert($scope.selectedAc);

			$http.get('/accountNo/' + this.selectedAc).then(function(res) {

				$scope.creadiAcBalance = res.data;

			});

		}

		$scope.cridetAcTotalNow = function() {
			//alert();
			if ($scope.totalAmmount > 1) {

				$scope.creadiAcTotal = this.tammount + this.creadiAcBalance[0];

			}

		}

	});
</script>
