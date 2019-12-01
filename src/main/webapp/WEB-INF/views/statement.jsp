<jsp:include page="navber.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center>
	<h1 style="margin-top: 30px">Balance Statement</h1>
	<hr></hr>
	<div style="margin-top: 100px"></div>
	
	<form style="margin-bottom: 20px" action="/statementSearch" method="post">
		<input type="text" placeholder="Enter Account No.." name="accountNo"/>
		<input type="submit" value="Search"/>
	</form>
	
			
	<table class="table table-bordered" style="width: 30%">
			<c:if test="${not empty statement}">
			<tr>
				<th style="text-align: center;">NAME : ${statement[0].name}</br>
					ACCOUNT NUMBER : ${statement[0].accountNo}
				</th>
			</tr>
			</c:if>			
		<c:forEach var="st" items="${statement}">


			<tr>	
				<td style="text-align: center;">
				<c:if test="${not empty st.transectionDate}">
					Transaction Date : ${st.transectionDate}</br>
				</c:if>
				<c:if test="${st.dipoBalance > 0}">
					Deposit Balance : ${st.dipoBalance}</br>
				</c:if>				
				<c:if test="${st.withdrowBalance > 0}">
					Withdraw Balance : ${st.withdrowBalance}</br>
				</c:if>
				<c:if test="${st.transferAmount > 0}">
					Transfer Amount : ${st.transferAmount}</br>
				</c:if>
				<c:if test="${! st.crAccountNo.equals('-')}">
					Credited Account No. : ${st.crAccountNo}</br>
				</c:if>
				<c:if test="${! st.drAccount.equals('-')}">
					Debited  Account No. : ${st.drAccount}</br>
				</c:if>					
				<c:if test="${st.crAccount>0}">
					Credit  Amount : ${st.crAccount}</br>
				</c:if>
				<c:if test="${st.totalbalance > 0}">
					Total Balance : ${st.totalbalance}</br>
				</c:if>
				<%-- Withdraw Balance ${st.withdrowBalance}</br>
				${st.transferAmount}
				${st.crAccountNo}
				${st.drAccount}
				${st.crAccount} --%>
				
				</td>				
				
			</tr>	 		
		</c:forEach>

	</table>
	<div style="margin-top: 100px"></div>
</center>
