<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Customer Payment Method</title>
</head>
<body>

	<form:form modelAttribute="payment" action= "${pageContext.request.contextPath}/customer/addPaymentMethod" method="get">
		<table>
                <tr>
                    <td><form:label path="cardNumber">Card Number :</form:label></td>
                    <td><form:input path="cardNumber"/></td>
                    <td><form:errors path="cardNumber" /></td>
                </tr>
                <tr>
                    <td><form:label path="cardName">Name on Card :</form:label></td>
                    <td><form:input path="cardName"/></td>
                    <td><form:errors path="cardName" /></td>
                </tr>
                <tr>
                    <td><form:label path="cardType">Card Type :</form:label></td>
                    <td><form:input path="cardType"/></td>
                    <td><form:errors path="cardType" /></td>
                </tr>
                <tr>
                    <td><form:label path="customer.customerId" required="required">Customer Id :</form:label></td>
                    <td><form:input type="number" path="customer.customerId"/></td>
                    <td><form:errors path="customer.customerId" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
	</form:form>
</body>
</html>