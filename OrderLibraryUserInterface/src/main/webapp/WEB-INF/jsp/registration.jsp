<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<jsp:include page="views/Menu.jsp"></jsp:include>  
	<form:form modelAttribute="NewCustomer" action= "${pageContext.request.contextPath}/customer/register" method="POST">
		<table>
                <tr>
                    <td><form:label path="customerName">Name</form:label></td>
                    <td><form:input path="customerName"/></td>
                </tr>
                <tr>
                    <td><form:label path="dob">Date of Birth</form:label></td>
                    <td><form:input path="dob"/>(yyyy/mm/dd)</td>
                </tr>
                <tr>
                    <td><form:label path="anualSalary">Annual Salary</form:label></td>
                    <td><form:input path="anualSalary"/></td>
                </tr>
                <tr>
                    <td><form:label path="address">Address</form:label></td>
                </tr>
                <tr>
                    <td><form:label path="address.country">Country</form:label></td>
                    <td><form:input path="address.country"/></td>
                </tr>
                <tr>
                    <td><form:label path="address.city">City</form:label></td>
                    <td><form:input path="address.city"/></td>
                </tr>
                <tr>
                    <td><form:label path="address.state">State</form:label></td>
                    <td><form:input path="address.state"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
	</form:form>
	
	${message}
	<jsp:include page="views/viewUser.jsp"></jsp:include>
</body>
</html>