<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="user.registration.title" /></title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<jsp:include page="logout.jsp"></jsp:include>
	
	<form:form action="${contextPath}/user/register" commandName="user">
		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<td><spring:message code="user.username.lbl" />:</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.password.lbl" />:</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.dob.lbl" />:</td>
				<td><form:input path="dob" /> (MM-dd-yyyy)</td>
				<td><form:errors path="dob" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.gender.lbl" />:</td>
				<td><form:checkbox path="gender" value="M" />Male <form:checkbox
						path="gender" value="F" />Female <form:checkbox path="gender"
						value="O" />Other</td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.anualSalary.lbl" />:</td>
				<td><form:input path="anualSalary" /></td>
				<td><form:errors path="anualSalary" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.country.lbl" />:</td>
				<td><form:select path="country">
						<form:options items="${countryCodes}" />
					</form:select></td>
				<td><form:errors path="country" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.email.lbl" />:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Salaried:</td>
				<td><form:select path="salaried">
						<form:option value="Yes" id="Yes" />
						<form:option value="No" id="No" />
					</form:select></td>
				<td><form:errors path="salaried" cssClass="error" /></td>
			</tr>
			<tr>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>