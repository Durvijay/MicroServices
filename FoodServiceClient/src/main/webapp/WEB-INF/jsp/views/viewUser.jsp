<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>



<body>
	<div class="container">
	 <c:if test="${customers != null}">
		<table class="table" border="1">
		<tr>
			<th colspan="2">User Details</th>
		</tr>
		<tr>
			<th><spring:message code="user.username.lbl" /></th>
			<th><spring:message code="user.dob.lbl" /></th>
			<th><spring:message code="user.anualSalary.lbl" /></th>
			<th><spring:message code="user.country.lbl" /></th>
			<th><spring:message code="user.address.city.lbl" /></th>
			<th><spring:message code="user.address.state.lbl" /></th>
		</tr>
		 <c:forEach var="customer" items="${customers}"> 
			<tr>
				<td>${customer.customerName}</td>
				<td>${customer.dob}</td>
				<td>${customer.anualSalary}</td>
				<td>${customer.address.city}</td>
				<td>${customer.address.country}</td>
				<td>${customer.address.state}</td>
			</tr>
		 </c:forEach> 
	</table>
		
		</c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>